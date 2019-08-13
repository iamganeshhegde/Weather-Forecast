package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WeatherForecast(
    @SerializedName("location")
    @Expose var location: Location? = null,
    @SerializedName("current")
    @Expose
    private var current: Current? = null,
    @SerializedName("forecast")
    @Expose var forecast: Forecast? = null
) {
}