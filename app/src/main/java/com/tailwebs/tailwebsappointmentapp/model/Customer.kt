package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Customer {
    @SerializedName("id")
    @Expose
    private var id = 0

    @SerializedName("first_name")
    @Expose
    private var first_name: String? = null

    @SerializedName("last_name")
    @Expose
    private var last_name: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("mobile")
    @Expose
    private var mobile: String? = null

    @SerializedName("gender")
    @Expose
    private var gender: String? = null

    @SerializedName("bill_to_shipping_address")
    @Expose
    private var bill_to_shipping_address = false

    @SerializedName("profile_images")
    @Expose
    private var profile_images: ProfileImages? = null

    @SerializedName("tags")
    @Expose
    private var tags: ArrayList<String?>? = null


    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getFirst_name(): String? {
        return first_name
    }

    fun setFirst_name(first_name: String?) {
        this.first_name = first_name
    }

    fun getLast_name(): String? {
        return last_name
    }

    fun setLast_name(last_name: String?) {
        this.last_name = last_name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getMobile(): String? {
        return mobile
    }

    fun setMobile(mobile: String?) {
        this.mobile = mobile
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String?) {
        this.gender = gender
    }

    fun isBill_to_shipping_address(): Boolean {
        return bill_to_shipping_address
    }

    fun setBill_to_shipping_address(bill_to_shipping_address: Boolean) {
        this.bill_to_shipping_address = bill_to_shipping_address
    }

    fun getProfile_images(): ProfileImages? {
        return profile_images
    }

    fun setProfile_images(profile_images: ProfileImages?) {
        this.profile_images = profile_images
    }

    fun getTags(): ArrayList<String?>? {
        return tags
    }

    fun setTags(tags: ArrayList<String?>?) {
        this.tags = tags
    }
}