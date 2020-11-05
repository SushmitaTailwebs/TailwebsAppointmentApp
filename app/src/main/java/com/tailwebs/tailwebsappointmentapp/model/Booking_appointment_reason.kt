package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Booking_appointment_reason {
    @SerializedName("id")
    @Expose
    private var id = 0

    @SerializedName("code")
    @Expose
    private var code: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String?) {
        this.code = code
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}