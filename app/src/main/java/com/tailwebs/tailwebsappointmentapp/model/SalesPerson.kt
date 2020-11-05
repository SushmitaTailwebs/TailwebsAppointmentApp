package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SalesPerson {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("preferred_name")
    @Expose
    private var preferred_name: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("primary_phone")
    @Expose
    private var primary_phone: String? = null

    @SerializedName("alternate_phone")
    @Expose
    private var alternate_phone: String? = null

    @SerializedName("state")
    @Expose
    private var state: String? = null

    @SerializedName("is_password_changed")
    @Expose
    private var is_password_changed = false

    @SerializedName("dob")
    @Expose
    private var dob: String? = null

    @SerializedName("gender")
    @Expose
    private var gender: String? = null

    @SerializedName("profile_images")
    @Expose
    private var profile_images: ProfileImages? = null

    @SerializedName("address")
    @Expose
    private var address: Address? = null

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address?) {
        this.address = address
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getPreferred_name(): String? {
        return preferred_name
    }

    fun setPreferred_name(preferred_name: String?) {
        this.preferred_name = preferred_name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getPrimary_phone(): String? {
        return primary_phone
    }

    fun setPrimary_phone(primary_phone: String?) {
        this.primary_phone = primary_phone
    }

    fun getAlternate_phone(): String? {
        return alternate_phone
    }

    fun setAlternate_phone(alternate_phone: String?) {
        this.alternate_phone = alternate_phone
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun isIs_password_changed(): Boolean {
        return is_password_changed
    }

    fun setIs_password_changed(is_password_changed: Boolean) {
        this.is_password_changed = is_password_changed
    }

    fun getDob(): String? {
        return dob
    }

    fun setDob(dob: String?) {
        this.dob = dob
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String?) {
        this.gender = gender
    }


    fun getProfile_images(): ProfileImages? {
        return profile_images
    }

    fun setProfile_images(profile_images: ProfileImages?) {
        this.profile_images = profile_images
    }
}