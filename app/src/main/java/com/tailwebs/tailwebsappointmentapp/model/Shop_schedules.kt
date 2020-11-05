package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Shop_schedules {
    @SerializedName("day_name")
    @Expose
    private var day_name: String? = null

    @SerializedName("day")
    @Expose
    private var day = 0

    @SerializedName("is_day_off")
    @Expose
    private var is_day_off = false

    @SerializedName("start_time")
    @Expose
    private var start_time: String? = null

    @SerializedName("end_time")
    @Expose
    private var end_time: String? = null

    fun getDay_name(): String? {
        return day_name
    }

    fun setDay_name(day_name: String?) {
        this.day_name = day_name
    }

    fun getDay(): Int {
        return day
    }

    fun setDay(day: Int) {
        this.day = day
    }

    fun isIs_day_off(): Boolean {
        return is_day_off
    }

    fun setIs_day_off(is_day_off: Boolean) {
        this.is_day_off = is_day_off
    }

    fun getStart_time(): String? {
        return start_time
    }

    fun setStart_time(start_time: String?) {
        this.start_time = start_time
    }

    fun getEnd_time(): String? {
        return end_time
    }

    fun setEnd_time(end_time: String?) {
        this.end_time = end_time
    }
}