package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Color_code {
    @SerializedName("dark_color")
    @Expose
    private var dark_color: String? = null

    @SerializedName("light_color")
    @Expose
    private var light_color: String? = null

    fun getDark_color(): String? {
        return dark_color
    }

    fun setDark_color(dark_color: String?) {
        this.dark_color = dark_color
    }

    fun getLight_color(): String? {
        return light_color
    }

    fun setLight_color(light_color: String?) {
        this.light_color = light_color
    }
}