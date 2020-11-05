package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Shop {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null


    @SerializedName("code")
    @Expose
    private var code: String? = null

    @SerializedName("phone")
    @Expose
    private var phone: String? = null

    @SerializedName("alternate_phone")
    @Expose
    private var alternate_phone: String? = null

    @SerializedName("dark_color_code")
    @Expose
    private var dark_color_code: String? = null

    @SerializedName("light_color_code")
    @Expose
    private var light_color_code: String? = null

    @SerializedName("shop_timing_in_format")
    @Expose
    private var shop_timing_in_format: String? = null

    @SerializedName("shop_open_timing")
    @Expose
    private var shop_open_timing: String? = null

    @SerializedName("address")
    @Expose
    private var address: Address? = null

    @SerializedName("shop_schedules")
    @Expose
    private var shop_schedules: ArrayList<Shop_schedules?>? = null

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

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String?) {
        this.code = code
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone
    }

    fun getAlternate_phone(): String? {
        return alternate_phone
    }

    fun setAlternate_phone(alternate_phone: String?) {
        this.alternate_phone = alternate_phone
    }

    fun getDark_color_code(): String? {
        return dark_color_code
    }

    fun setDark_color_code(dark_color_code: String?) {
        this.dark_color_code = dark_color_code
    }

    fun getLight_color_code(): String? {
        return light_color_code
    }

    fun setLight_color_code(light_color_code: String?) {
        this.light_color_code = light_color_code
    }

    fun getShop_timing_in_format(): String? {
        return shop_timing_in_format
    }

    fun setShop_timing_in_format(shop_timing_in_format: String?) {
        this.shop_timing_in_format = shop_timing_in_format
    }

    fun getShop_open_timing(): String? {
        return shop_open_timing
    }

    fun setShop_open_timing(shop_open_timing: String?) {
        this.shop_open_timing = shop_open_timing
    }

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address?) {
        this.address = address
    }

    fun getShop_schedules(): ArrayList<Shop_schedules?>? {
        return shop_schedules
    }

    fun setShop_schedules(shop_schedules: ArrayList<Shop_schedules?>?) {
        this.shop_schedules = shop_schedules
    }
}