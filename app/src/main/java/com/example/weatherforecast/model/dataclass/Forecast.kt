package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Forecast {
    @SerializedName("forecastday")

    @Expose
    private var forecastday: ArrayList<Forecastday>? = null

    fun getForecastday(): ArrayList<Forecastday>? {
        return forecastday
    }

    fun setForecastday(forecastday: ArrayList<Forecastday>) {
        this.forecastday = forecastday
    }
}