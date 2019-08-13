package com.example.weatherforecast.model.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Condition_ {

    @SerializedName("text")
    @Expose
    private var text: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null
    @SerializedName("code")
    @Expose
    private var code: Int? = null

    fun getText(): String? {
        return text
    }

    fun setText(text: String) {
        this.text = text
    }

    fun getIcon(): String? {
        return icon
    }

    fun setIcon(icon: String) {
        this.icon = icon
    }

    fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }
}