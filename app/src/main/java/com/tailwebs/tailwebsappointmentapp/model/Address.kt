package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("line1")
    @Expose
    private var line1: String? = null

    @SerializedName("line2")
    @Expose
    private var line2: String? = null

    @SerializedName("is_geocoded")
    @Expose
    private var is_geocoded = false

    @SerializedName("google_place_id")
    @Expose
    private var google_place_id: String? = null

    @SerializedName("full_address")
    @Expose
    private var full_address: String? = null

    @SerializedName("city_name")
    @Expose
    private var city_name: String? = null

    @SerializedName("country_name")
    @Expose
    private var country_name: String? = null

    @SerializedName("pincode")
    @Expose
    private var pincode: String? = null

    @SerializedName("formatted_address")
    @Expose
    private var formatted_address: String? = null

    @SerializedName("lat")
    @Expose
    private var lat: String? = null

    @SerializedName("lng")
    @Expose
    private var lng: String? = null

    @SerializedName("timezone")
    @Expose
    private var timezone: String? = null

    @SerializedName("formatted_full_address")
    @Expose
    private var formatted_full_address: String? = null

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

    fun getLine1(): String? {
        return line1
    }

    fun setLine1(line1: String?) {
        this.line1 = line1
    }

    fun getLine2(): String? {
        return line2
    }

    fun setLine2(line2: String?) {
        this.line2 = line2
    }

    fun isIs_geocoded(): Boolean {
        return is_geocoded
    }

    fun setIs_geocoded(is_geocoded: Boolean) {
        this.is_geocoded = is_geocoded
    }

    fun getGoogle_place_id(): String? {
        return google_place_id
    }

    fun setGoogle_place_id(google_place_id: String?) {
        this.google_place_id = google_place_id
    }

    fun getFull_address(): String? {
        return full_address
    }

    fun setFull_address(full_address: String?) {
        this.full_address = full_address
    }

    fun getCity_name(): String? {
        return city_name
    }

    fun setCity_name(city_name: String?) {
        this.city_name = city_name
    }

    fun getCountry_name(): String? {
        return country_name
    }

    fun setCountry_name(country_name: String?) {
        this.country_name = country_name
    }

    fun getPincode(): String? {
        return pincode
    }

    fun setPincode(pincode: String?) {
        this.pincode = pincode
    }

    fun getFormatted_address(): String? {
        return formatted_address
    }

    fun setFormatted_address(formatted_address: String?) {
        this.formatted_address = formatted_address
    }

    fun getLat(): String? {
        return lat
    }

    fun setLat(lat: String?) {
        this.lat = lat
    }

    fun getLng(): String? {
        return lng
    }

    fun setLng(lng: String?) {
        this.lng = lng
    }

    fun getTimezone(): String? {
        return timezone
    }

    fun setTimezone(timezone: String?) {
        this.timezone = timezone
    }

    fun getFormatted_full_address(): String? {
        return formatted_full_address
    }

    fun setFormatted_full_address(formatted_full_address: String?) {
        this.formatted_full_address = formatted_full_address
    }

}