package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Forecast(
    @SerializedName("forecastday")

    @Expose var forecastday: ArrayList<Forecastday>? = null
) {
}