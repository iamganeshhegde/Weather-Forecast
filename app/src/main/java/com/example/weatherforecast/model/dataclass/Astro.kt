package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class Astro(@SerializedName("sunrise")
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

}