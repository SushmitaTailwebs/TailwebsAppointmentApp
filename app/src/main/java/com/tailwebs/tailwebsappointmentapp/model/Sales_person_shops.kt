package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Sales_person_shops {
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

    @SerializedName("sales_person_shops")
    @Expose
    private var sales_person_shops: ArrayList<Sales_person_shops_List?>? = null

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

    fun getSales_person_shops(): ArrayList<Sales_person_shops_List?>? {
        return sales_person_shops
    }

    fun setSales_person_shops(sales_person_shops: ArrayList<Sales_person_shops_List?>?) {
        this.sales_person_shops = sales_person_shops
    }
}