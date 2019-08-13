package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Location(
    @SerializedName("name")
    @Expose
     var name: String? = null,
    @SerializedName("region")
@Expose
 var region: String? = null,
@SerializedName("country")
@Expose
 var country: String? = null,
@SerializedName("lat")
@Expose
 var lat: Double? = null,
@SerializedName("lon")
@Expose
 var lon: Double? = null,
@SerializedName("tz_id")
@Expose
 var tzId: String? = null,
@SerializedName("localtime_epoch")
@Expose
 var localtimeEpoch: Int? = null,
@SerializedName("localtime")
@Expose
 var localtime: String? = null
) {


    /* fun getName(): String? {
         return name
     }

     fun setName(name: String) {
         this.name = name
     }

     fun getRegion(): String? {
         return region
     }

     fun setRegion(region: String) {
         this.region = region
     }

     fun getCountry(): String? {
         return country
     }

     fun setCountry(country: String) {
         this.country = country
     }

     fun getLat(): Double? {
         return lat
     }

     fun setLat(lat: Double?) {
         this.lat = lat
     }

     fun getLon(): Double? {
         return lon
     }

     fun setLon(lon: Double?) {
         this.lon = lon
     }

     fun getTzId(): String? {
         return tzId
     }

     fun setTzId(tzId: String) {
         this.tzId = tzId
     }

     fun getLocaltimeEpoch(): Int? {
         return localtimeEpoch
     }

     fun setLocaltimeEpoch(localtimeEpoch: Int?) {
         this.localtimeEpoch = localtimeEpoch
     }

     fun getLocaltime(): String? {
         return localtime
     }

     fun setLocaltime(localtime: String) {
         this.localtime = localtime
     }*/
}