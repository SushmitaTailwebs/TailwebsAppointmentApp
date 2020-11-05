package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Login {
    fun isSuccess(): Boolean {
        return success
    }

    fun setSuccess(success: Boolean) {
        this.success = success
    }

    @SerializedName("success")
    @Expose
    private var success = false

    @SerializedName("errors")
    @Expose
    private var errors: String? = null

    @SerializedName("notice")
    @Expose
    private var notice: String? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("secret_id")
    @Expose
    private var secretId: String? = null

    @SerializedName("secret")
    @Expose
    private var secret: String? = null

    @SerializedName("sales_person")
    @Expose
    private var sales_person: SalesPerson? = null


    fun getErrors(): String? {
        return errors
    }

    fun setErrors(errors: String?) {
        this.errors = errors
    }

    fun getNotice(): String? {
        return notice
    }

    fun setNotice(notice: String?) {
        this.notice = notice
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getSecretId(): String? {
        return secretId
    }

    fun setSecretId(secretId: String?) {
        this.secretId = secretId
    }

    fun getSecret(): String? {
        return secret
    }

    fun setSecret(secret: String?) {
        this.secret = secret
    }

    fun getSales_person(): SalesPerson? {
        return sales_person
    }

    fun setSales_person(sales_person: SalesPerson?) {
        this.sales_person = sales_person
    }
}