package com.example.weatherforecast.model.repository.networking

import com.example.weatherforecast.model.dataclass.WeatherForecast
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("forecast.json?")
    fun getWeatherForecast(@Query("key") key:String, @Query("q") searchQuery:String,@Query("days") days:Int):Observable<WeatherForecast>
}