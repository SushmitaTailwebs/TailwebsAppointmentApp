package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sales_person_shops_List {
    @SerializedName("is_default")
    @Expose
    private var is_default = false

    @SerializedName("shop")
    @Expose
    private var shop: Shop? = null

    fun isIs_default(): Boolean {
        return is_default
    }

    fun setIs_default(is_default: Boolean) {
        this.is_default = is_default
    }

    fun getShop(): Shop? {
        return shop
    }

    fun setShop(shop: Shop?) {
        this.shop = shop
    }
}