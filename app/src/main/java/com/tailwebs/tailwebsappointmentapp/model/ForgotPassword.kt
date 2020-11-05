package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ForgotPassword {
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

    @SerializedName("sales_person")
    @Expose
    private var sales_person: SalesPerson? = null

    fun getSales_person(): SalesPerson? {
        return sales_person
    }

    fun setSales_person(sales_person: SalesPerson?) {
        this.sales_person = sales_person
    }

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
}