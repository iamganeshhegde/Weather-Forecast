package com.example.weatherforecast.view.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weatherforecast.R
import com.example.weatherforecast.model.dataclass.Forecastday
import com.example.weatherforecast.model.dataclass.WeatherForecast
import com.example.weatherforecast.view.adapters.WeatherAdapter
import com.example.weatherforecast.viewmodel.WeatherViewModel
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var TAG = MainActivity::class.java.name
    lateinit var weatherViewModel: WeatherViewModel
     var weatherAdapter: WeatherAdapter? = null
    lateinit var activityMainBinding: com.example.weatherforecast.databinding.ActivityMainBinding
    lateinit var animation:Animation
    lateinit var rotateAnimation :Animation


    //    lateinit var mFusedLocationClient: FusedLocationProviderClient
//    lateinit var mSettingsClient: SettingsClient
//    lateinit var mLocationRequest: LocationRequest
//    lateinit var mLocationSettingRequest: LocationSettingsRequest
//
//    lateinit var mLocationCallbacks: LocationCallback
//    lateinit var geocoder: Geocoder
    val permission = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)

    val UPDATE_INTERVAL: Long = 10 * 1000
    val FASTEST_INTERVAL: Long = 3 * 1000
    val REQUEST_CHECK_SETTINGS_GPS = 102
    val REQUEST_CODE = 101


    var latitude: Double = 0.0
    var longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        setLocationPermissions()

       animation  = AnimationUtils.loadAnimation(this,R.anim.anim_move)
        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate)

//        rvWeatherForecast.startAnimation(animation)


        weatherViewModel.getLocationUpdates().observe(this, Observer {


            saveLocationDetails(it)

        })



        /* mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
         mSettingsClient = LocationServices.getSettingsClient(this)

         setLocationPermissions()

         mLocationCallbacks = object : LocationCallback() {
             override fun onLocationResult(locationResult: LocationResult?) {
                 super.onLocationResult(locationResult)

                 locationResult ?: return

                 saveLocationDetails(locationResult.lastLocation)
                 stopLocationUpdates()
             }
         }*/


        ivRefresh.setOnClickListener {

            setLocationPermissions()
        }
    }

   /* private fun stopLocationUpdates() {

        mFusedLocationClient.removeLocationUpdates(mLocationCallbacks)
    }*/

    private fun saveLocationDetails(result: Location) {
        try {

//            if (NetworkUtils.hasConnectivity(this)) {
            //        latitude = locationResult.lastLocation.latitude
            latitude = result.latitude
//        longitude = locationResult.lastLocation.longitude
            longitude = result.longitude

//            }


            Log.i(TAG, "Lat and long " + latitude + " " + longitude)

            //call weather forecast
            getWeatherForecast()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun setLocationPermissions() {

        if (!isPermissionsAvailable()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permission, REQUEST_CODE)
            }
        } else {

            createLocationRequest()
        }
    }

    private fun isPermissionsAvailable(): Boolean {
        return (ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isNotEmpty()) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        //permission granted for location
                        createLocationRequest()
                        tvNoInternet.visibility = GONE


                    } else {
                        if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                            tvNoInternet.visibility = VISIBLE
                        }
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.i(TAG, "Location settings calling$data")


        if (requestCode == REQUEST_CHECK_SETTINGS_GPS) {
            if (
                resultCode == Activity.RESULT_OK) {

                //this is to check
                weatherViewModel.startLocationUpdates()
//                createLocationRequest()


                //call this if nothing works change it
//                startLocationUpdates()

            } else if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    fun createLocationRequest() {


        weatherViewModel.getLocationUpdates()



       /* mLocationRequest = LocationRequest().apply {
            interval = UPDATE_INTERVAL
            fastestInterval = FASTEST_INTERVAL
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        var builder = LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest)

        mLocationSettingRequest = builder.build()

        var task = mSettingsClient.checkLocationSettings(mLocationSettingRequest)

        task.addOnSuccessListener { locationSettingsResponse ->
            //            showToast("task called startLocationUpDates")

            startLocationUpdates()
//            getLastKnownLocation()
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                exception.startResolutionForResult(this, REQUEST_CHECK_SETTINGS_GPS)
            }
        }*/
    }

   /* fun startLocationUpdates() {
        if (isPermissionsAvailable()) {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallbacks, Looper.myLooper())
        }
    }*/

    private fun getWeatherForecast() {

        if(isThereInternetConnection()){
            tvNoInternet.visibility = View.GONE

            ivRefresh.startAnimation(rotateAnimation)

            weatherViewModel.getForecastDetails(latitude, longitude)?.observe(this,
                androidx.lifecycle.Observer<WeatherForecast> {

                    updateRecyclerViewData(it)
                })
        }else{
            tvNoInternet.visibility = View.VISIBLE
            Toast.makeText(this,"Turn on internet and click on refresh image to get the updated weather report",Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateRecyclerViewData(weatherForecast: WeatherForecast?) {

        if (weatherForecast != null) {

            Log.i("Check","Recycler view created  these many times")

            var currentDayDetails = weatherForecast.getForecast()?.getForecastday()?.get(0)
            var name = weatherForecast.getLocation()?.name

            updateCurrentDayData(currentDayDetails, name)

            var listOfForecast: ArrayList<Forecastday>? = weatherForecast.getForecast()?.getForecastday()

            //  weatherAdapter.updateListInRecyclerView(listOfForecast)

            if(weatherAdapter == null){
                weatherAdapter = WeatherAdapter(this, listOfForecast)
            }else{
                weatherAdapter!!.updateListInRecyclerView(listOfForecast)
            }
            activityMainBinding.adapter = weatherAdapter


            rvWeatherForecast.isNestedScrollingEnabled = false

            ivRefresh.clearAnimation()
            ivRefresh.visibility = View.GONE
//            rvWeatherForecast.clearAnimation()

        }
    }

    private fun updateCurrentDayData(
        currentDayDetails: Forecastday?,
        name: String?
    ) {
        activityMainBinding.forecastCurrent = currentDayDetails
        activityMainBinding.locationName = name
//        tvCity.text = name
        /*if (currentDayDetails != null) {
            tvCurrentDayDegrees.text = currentDayDetails.getDay()?.getAvgtempC().toString()

                Picasso.get().load("https:" + currentDayDetails.getDay()?.getCondition()!!.getIcon()).into(ivCurrentDay)
        }*/

    }

    override fun onResume() {
        super.onResume()

        //checking
        createLocationRequest()

        //this was working code
//        startLocationUpdates()
    }

    override fun onPause() {
        super.onPause()

        //this is to check
//        createLocationRequest()
        weatherViewModel.stopLocationUpdates()


        //this was working
//        stopLocationUpdates()
    }

    fun isThereInternetConnection(): Boolean {
        val isConnected: Boolean

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting

        return isConnected
    }
}
