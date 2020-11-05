package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Appointments {
    @SerializedName("id")
    @Expose
    private var id = 0

    @SerializedName("first_name")
    @Expose
    private var first_name: String? = null

    @SerializedName("last_name")
    @Expose
    private var last_name: String? = null

    @SerializedName("booking_appointment_reason")
    @Expose
    private var booking_appointment_reason: Booking_appointment_reason? = null

    @SerializedName("start_time")
    @Expose
    private var start_time: String? = null

    @SerializedName("end_time")
    @Expose
    private var end_time: String? = null

    @SerializedName("mobile")
    @Expose
    private var mobile: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("customer_id")
    @Expose
    private var customer_id: String? = null

    @SerializedName("state")
    @Expose
    private var state: String? = null

    @SerializedName("booking_appointment_reason_id")
    @Expose
    private var booking_appointment_reason_id = 0

    @SerializedName("reminder_flag")
    @Expose
    private var reminder_flag = false

    @SerializedName("customer_comment")
    @Expose
    private var customer_comment: String? = null

    @SerializedName("appointmentable_type")
    @Expose
    private var appointmentable_type: String? = null

    @SerializedName("appointmentable_id")
    @Expose
    private var appointmentable_id = 0

    @SerializedName("appointment_number")
    @Expose
    private var appointment_number: String? = null

    @SerializedName("gender")
    @Expose
    private var gender: String? = null

    @SerializedName("customer")
    @Expose
    private var customer: Customer? = null

    fun getMobile(): String? {
        return mobile
    }

    fun setMobile(mobile: String?) {
        this.mobile = mobile
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getCustomer_id(): String? {
        return customer_id
    }

    fun setCustomer_id(customer_id: String?) {
        this.customer_id = customer_id
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getBooking_appointment_reason_id(): Int {
        return booking_appointment_reason_id
    }

    fun setBooking_appointment_reason_id(booking_appointment_reason_id: Int) {
        this.booking_appointment_reason_id = booking_appointment_reason_id
    }

    fun isReminder_flag(): Boolean {
        return reminder_flag
    }

    fun setReminder_flag(reminder_flag: Boolean) {
        this.reminder_flag = reminder_flag
    }

    fun getCustomer_comment(): String? {
        return customer_comment
    }

    fun setCustomer_comment(customer_comment: String?) {
        this.customer_comment = customer_comment
    }

    fun getAppointmentable_type(): String? {
        return appointmentable_type
    }

    fun setAppointmentable_type(appointmentable_type: String?) {
        this.appointmentable_type = appointmentable_type
    }

    fun getAppointmentable_id(): Int {
        return appointmentable_id
    }

    fun setAppointmentable_id(appointmentable_id: Int) {
        this.appointmentable_id = appointmentable_id
    }

    fun getAppointment_number(): String? {
        return appointment_number
    }

    fun setAppointment_number(appointment_number: String?) {
        this.appointment_number = appointment_number
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String?) {
        this.gender = gender
    }

    fun getCustomer(): Customer? {
        return customer
    }

    fun setCustomer(customer: Customer?) {
        this.customer = customer
    }

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

    fun getBooking_appointment_reason(): Booking_appointment_reason? {
        return booking_appointment_reason
    }

    fun setBooking_appointment_reason(booking_appointment_reason: Booking_appointment_reason?) {
        this.booking_appointment_reason = booking_appointment_reason
    }

    fun getStart_time(): String? {
        return start_time
    }

    fun setStart_time(start_time: String?) {
        this.start_time = start_time
    }

    fun getEnd_time(): String? {
        return end_time
    }

    fun setEnd_time(end_time: String?) {
        this.end_time = end_time
    }
}