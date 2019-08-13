package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Day {

    @SerializedName("maxtemp_c")
    @Expose
    private var maxtempC: Double? = null
    @SerializedName("maxtemp_f")
    @Expose
    private var maxtempF: Double? = null
    @SerializedName("mintemp_c")
    @Expose
    private var mintempC: Double? = null
    @SerializedName("mintemp_f")
    @Expose
    private var mintempF: Double? = null
    @SerializedName("avgtemp_c")
    @Expose
    private var avgtempC: Double? = null
    @SerializedName("avgtemp_f")
    @Expose
    private var avgtempF: Double? = null
    @SerializedName("maxwind_mph")
    @Expose
    private var maxwindMph: Double? = null
    @SerializedName("maxwind_kph")
    @Expose
    private var maxwindKph: Double? = null
    @SerializedName("totalprecip_mm")
    @Expose
    private var totalprecipMm: Double? = null
    @SerializedName("totalprecip_in")
    @Expose
    private var totalprecipIn: Double? = null
    @SerializedName("avgvis_km")
    @Expose
    private var avgvisKm: Double? = null
    @SerializedName("avgvis_miles")
    @Expose
    private var avgvisMiles: Double? = null
    @SerializedName("avghumidity")
    @Expose
    private var avghumidity: Double? = null
    @SerializedName("condition")
    @Expose
    private var condition: Condition_? = null
    @SerializedName("uv")
    @Expose
    private var uv: Double? = null

    fun getMaxtempC(): Double? {
        return maxtempC
    }

    fun setMaxtempC(maxtempC: Double?) {
        this.maxtempC = maxtempC
    }

    fun getMaxtempF(): Double? {
        return maxtempF
    }

    fun setMaxtempF(maxtempF: Double?) {
        this.maxtempF = maxtempF
    }

    fun getMintempC(): Double? {
        return mintempC
    }

    fun setMintempC(mintempC: Double?) {
        this.mintempC = mintempC
    }

    fun getMintempF(): Double? {
        return mintempF
    }

    fun setMintempF(mintempF: Double?) {
        this.mintempF = mintempF
    }

    fun getAvgtempC(): Double? {
        return avgtempC
    }

    fun setAvgtempC(avgtempC: Double?) {
        this.avgtempC = avgtempC
    }

    fun getAvgtempF(): Double? {
        return avgtempF
    }

    fun setAvgtempF(avgtempF: Double?) {
        this.avgtempF = avgtempF
    }

    fun getMaxwindMph(): Double? {
        return maxwindMph
    }

    fun setMaxwindMph(maxwindMph: Double?) {
        this.maxwindMph = maxwindMph
    }

    fun getMaxwindKph(): Double? {
        return maxwindKph
    }

    fun setMaxwindKph(maxwindKph: Double?) {
        this.maxwindKph = maxwindKph
    }

    fun getTotalprecipMm(): Double? {
        return totalprecipMm
    }

    fun setTotalprecipMm(totalprecipMm: Double?) {
        this.totalprecipMm = totalprecipMm
    }

    fun getTotalprecipIn(): Double? {
        return totalprecipIn
    }

    fun setTotalprecipIn(totalprecipIn: Double?) {
        this.totalprecipIn = totalprecipIn
    }

    fun getAvgvisKm(): Double? {
        return avgvisKm
    }

    fun setAvgvisKm(avgvisKm: Double?) {
        this.avgvisKm = avgvisKm
    }

    fun getAvgvisMiles(): Double? {
        return avgvisMiles
    }

    fun setAvgvisMiles(avgvisMiles: Double?) {
        this.avgvisMiles = avgvisMiles
    }

    fun getAvghumidity(): Double? {
        return avghumidity
    }

    fun setAvghumidity(avghumidity: Double?) {
        this.avghumidity = avghumidity
    }

    fun getCondition(): Condition_? {
        return condition
    }

    fun setCondition(condition: Condition_) {
        this.condition = condition
    }

    fun getUv(): Double? {
        return uv
    }

    fun setUv(uv: Double?) {
        this.uv = uv
    }
}