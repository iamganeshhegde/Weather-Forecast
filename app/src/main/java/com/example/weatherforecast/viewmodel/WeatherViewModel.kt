package com.example.weatherforecast.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherforecast.model.dataclass.WeatherForecast
import com.example.weatherforecast.model.repository.WeatherRepository
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*

class WeatherViewModel(application: Application):AndroidViewModel(application) {

    var appApplication:Application = application

    var repo:WeatherRepository = WeatherRepository()

    var location: MutableLiveData<Location> = MutableLiveData<Location>()
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    var mLocationRequest: LocationRequest? = null

    val UPDATE_INTERVAL: Long = 10 * 1000
    val FASTEST_INTERVAL: Long = 3 * 1000

    lateinit var mLocationSettingRequest: LocationSettingsRequest
    var mSettingsClient: SettingsClient = LocationServices.getSettingsClient(application)

    init {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(appApplication)
        mSettingsClient = LocationServices.getSettingsClient(appApplication)
    }

    //to get the weather forecast details from repo
    fun getForecastDetails(latitude: Double, longitude: Double):LiveData<WeatherForecast>?{
        return repo.getWeatherForecastData(latitude,longitude)
    }

    //get location
    fun getLocationUpdates():MutableLiveData<Location>{
        //createLocationRequest
            mLocationRequest = LocationRequest()

            mLocationRequest?.apply {
                interval = UPDATE_INTERVAL
                fastestInterval = FASTEST_INTERVAL
                priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
            }


            var builder = LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest!!)

            mLocationSettingRequest = builder.build()

            var task = mSettingsClient.checkLocationSettings(mLocationSettingRequest)

            task.addOnSuccessListener {
                startLocationUpdates()
            }

            task.addOnFailureListener {
                if(it is ResolvableApiException){
                }
            }
        return location
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallbacks, Looper.myLooper())
    }


    var mLocationCallbacks = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            super.onLocationResult(locationResult)

            if(locationResult != null){
                location.value = locationResult.lastLocation
                stopLocationUpdates()
            }
        }
    }

    fun stopLocationUpdates() {
        mFusedLocationClient.removeLocationUpdates(mLocationCallbacks)
    }

}