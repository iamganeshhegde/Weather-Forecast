package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Forecastday {

    @SerializedName("date")
    @Expose
    private var date: String? = null
    @SerializedName("date_epoch")
    @Expose
    private var dateEpoch: Int? = null
    @SerializedName("day")
    @Expose
    private var day: Day? = null
    @SerializedName("astro")
    @Expose
    private var astro: Astro? = null

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun getDateEpoch(): Int? {
        return dateEpoch
    }

    fun setDateEpoch(dateEpoch: Int?) {
        this.dateEpoch = dateEpoch
    }

    fun getDay(): Day? {
        return day
    }

    fun setDay(day: Day) {
        this.day = day
    }

    fun getAstro(): Astro? {
        return astro
    }

    fun setAstro(astro: Astro) {
        this.astro = astro
    }
}