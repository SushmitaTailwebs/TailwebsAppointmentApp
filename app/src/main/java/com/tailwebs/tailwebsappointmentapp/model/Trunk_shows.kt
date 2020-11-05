package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Trunk_shows {
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

    @SerializedName("trunk_shows")
    @Expose
    private var trunk_shows: ArrayList<Trunk_shows_list?>? = null

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

    fun getTrunk_shows(): ArrayList<Trunk_shows_list?>? {
        return trunk_shows
    }

    fun setTrunk_shows(trunk_shows: ArrayList<Trunk_shows_list?>?) {
        this.trunk_shows = trunk_shows
    }
}