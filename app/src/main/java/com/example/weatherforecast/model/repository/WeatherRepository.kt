package com.example.weatherforecast.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherforecast.model.dataclass.WeatherForecast
import com.example.weatherforecast.model.repository.networking.RestApiImpl
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherRepository {

    lateinit var restApi: RestApiImpl
    var WEATHER_API_KEY = "ad714eba9cb74372b0e101947190504"
    lateinit var disposable: CompositeDisposable
    var TAG = WeatherRepository::class.java.name
    var mutableWeatherData:MutableLiveData<WeatherForecast> = MutableLiveData<WeatherForecast>()

    fun getWeatherForecastData(latitude: Double, longitude: Double):LiveData<WeatherForecast>?{

        restApi = RestApiImpl()

        restApi.getWeatherForecast(WEATHER_API_KEY, "$latitude,$longitude",10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherForecast> {
                override fun onComplete() {

                    Log.i(TAG, "completed emitting")
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: WeatherForecast) {
                    mutableWeatherData.value = t
                }

                override fun onError(e: Throwable) {

                    e.printStackTrace()
                }
            })

        return mutableWeatherData

    }
}