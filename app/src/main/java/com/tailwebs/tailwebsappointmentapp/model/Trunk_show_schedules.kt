package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Trunk_show_schedules {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("event_date")
    @Expose
    private var event_date: String? = null

    @SerializedName("start_time")
    @Expose
    private var start_time: String? = null

    @SerializedName("formatted_event_date_1")
    @Expose
    private var formatted_event_date_1: String? = null

    @SerializedName("formatted_event_date_2")
    @Expose
    private var formatted_event_date_2: String? = null

    @SerializedName("formatted_start_time_1")
    @Expose
    private var formatted_start_time_1: String? = null

    @SerializedName("formatted_start_time_2")
    @Expose
    private var formatted_start_time_2: String? = null

    @SerializedName("formatted_start_time_3")
    @Expose
    private var formatted_start_time_3: String? = null

    @SerializedName("formatted_end_time_1")
    @Expose
    private var formatted_end_time_1: String? = null

    @SerializedName("formatted_end_time_2")
    @Expose
    private var formatted_end_time_2: String? = null

    @SerializedName("formatted_end_time_3")
    @Expose
    private var formatted_end_time_3: String? = null

    @SerializedName("bookings")
    @Expose
    private var bookings = 0

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getEvent_date(): String? {
        return event_date
    }

    fun setEvent_date(event_date: String?) {
        this.event_date = event_date
    }

    fun getStart_time(): String? {
        return start_time
    }

    fun setStart_time(start_time: String?) {
        this.start_time = start_time
    }

    fun getFormatted_event_date_1(): String? {
        return formatted_event_date_1
    }

    fun setFormatted_event_date_1(formatted_event_date_1: String?) {
        this.formatted_event_date_1 = formatted_event_date_1
    }

    fun getFormatted_event_date_2(): String? {
        return formatted_event_date_2
    }

    fun setFormatted_event_date_2(formatted_event_date_2: String?) {
        this.formatted_event_date_2 = formatted_event_date_2
    }

    fun getFormatted_start_time_1(): String? {
        return formatted_start_time_1
    }

    fun setFormatted_start_time_1(formatted_start_time_1: String?) {
        this.formatted_start_time_1 = formatted_start_time_1
    }

    fun getFormatted_start_time_2(): String? {
        return formatted_start_time_2
    }

    fun setFormatted_start_time_2(formatted_start_time_2: String?) {
        this.formatted_start_time_2 = formatted_start_time_2
    }

    fun getFormatted_start_time_3(): String? {
        return formatted_start_time_3
    }

    fun setFormatted_start_time_3(formatted_start_time_3: String?) {
        this.formatted_start_time_3 = formatted_start_time_3
    }

    fun getFormatted_end_time_1(): String? {
        return formatted_end_time_1
    }

    fun setFormatted_end_time_1(formatted_end_time_1: String?) {
        this.formatted_end_time_1 = formatted_end_time_1
    }

    fun getFormatted_end_time_2(): String? {
        return formatted_end_time_2
    }

    fun setFormatted_end_time_2(formatted_end_time_2: String?) {
        this.formatted_end_time_2 = formatted_end_time_2
    }

    fun getFormatted_end_time_3(): String? {
        return formatted_end_time_3
    }

    fun setFormatted_end_time_3(formatted_end_time_3: String?) {
        this.formatted_end_time_3 = formatted_end_time_3
    }

    fun getBookings(): Int {
        return bookings
    }

    fun setBookings(bookings: Int) {
        this.bookings = bookings
    }
}