package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Astro(@SerializedName("sunrise")
            @Expose
             var sunrise: String? = null,

            @SerializedName("sunset")
            @Expose
            private var sunset: String? = null,

            @SerializedName("moonrise")
            @Expose
            private var moonrise: String? = null,

            @SerializedName("moonset")
            @Expose
            private var moonset: String? = null
            ) {
/*    @SerializedName("sunrise")
    @Expose
    private var sunrise: String? = null*/
   /* @SerializedName("sunset")
    @Expose
    private var sunset: String? = null*/
   /* @SerializedName("moonrise")
    @Expose
    private var moonrise: String? = null*/
   /* @SerializedName("moonset")
    @Expose
    private var moonset: String? = null*/

 /*   fun getSunrise(): String? {
        return sunrise
    }

    fun setSunrise(sunrise: String) {
        this.sunrise = sunrise
    }

    fun getSunset(): String? {
        return sunset
    }

    fun setSunset(sunset: String) {
        this.sunset = sunset
    }

    fun getMoonrise(): String? {
        return moonrise
    }

    fun setMoonrise(moonrise: String) {
        this.moonrise = moonrise
    }

    fun getMoonset(): String? {
        return moonset
    }

    fun setMoonset(moonset: String) {
        this.moonset = moonset
    }*/

}