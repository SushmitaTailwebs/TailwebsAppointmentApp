package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Appointments_Shop {
    @SerializedName("success")
    @Expose
    private var success = false

    @SerializedName("notice")
    @Expose
    private var notice: String? = null

    @SerializedName("errors")
    @Expose
    private var errors: String? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("appointments")
    @Expose
    private var appointments: ArrayList<Appointments?>? = null

    fun isSuccess(): Boolean {
        return success
    }

    fun setSuccess(success: Boolean) {
        this.success = success
    }

    fun getNotice(): String? {
        return notice
    }

    fun setNotice(notice: String?) {
        this.notice = notice
    }

    fun getErrors(): String? {
        return errors
    }

    fun setErrors(errors: String?) {
        this.errors = errors
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getAppointments(): ArrayList<Appointments?>? {
        return appointments
    }

    fun setAppointments(appointments: ArrayList<Appointments?>?) {
        this.appointments = appointments
    }
}