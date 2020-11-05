package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileImages {
    @SerializedName("available")
    @Expose
    private var available = false

    @SerializedName("thumb")
    @Expose
    private var thumb: String? = null

    @SerializedName("medium")
    @Expose
    private var medium: String? = null

    @SerializedName("original")
    @Expose
    private var original: String? = null

    fun isAvailable(): Boolean {
        return available
    }

    fun setAvailable(available: Boolean) {
        this.available = available
    }

    fun getThumb(): String? {
        return thumb
    }

    fun setThumb(thumb: String?) {
        this.thumb = thumb
    }

    fun getMedium(): String? {
        return medium
    }

    fun setMedium(medium: String?) {
        this.medium = medium
    }

    fun getOriginal(): String? {
        return original
    }

    fun setOriginal(original: String?) {
        this.original = original
    }
}