package com.example.weatherforecast.model.repository.networking

import com.example.weatherforecast.model.dataclass.WeatherForecast
import io.reactivex.Observable

class RestApiImpl : RestApi {

    var apiClient = ApiClient()

    override fun getWeatherForecast(key: String, searchQuery: String,days:Int): Observable<WeatherForecast> {

        return apiClient.connectToApi().getWeatherForecast(key, searchQuery,days)

    }
}