package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class WeatherForecast {

    @SerializedName("location")
    @Expose
    private var location: Location? = null
    @SerializedName("current")
    @Expose
    private var current: Current? = null
    @SerializedName("forecast")
    @Expose
    private var forecast: Forecast? = null


    fun getLocation(): Location? {
        return location
    }

    fun setLocation(location: Location) {
        this.location = location
    }

    fun getCurrent(): Current? {
        return current
    }

    fun setCurrent(current: Current) {
        this.current = current
    }

    fun getForecast(): Forecast? {
        return forecast
    }

    fun setForecast(forecast: Forecast) {
        this.forecast = forecast
    }


}