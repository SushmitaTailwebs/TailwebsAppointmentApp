package com.tailwebs.tailwebsappointmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Trunk_shows_list {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("code")
    @Expose
    private var code: String? = null

    @SerializedName("start_date")
    @Expose
    private var start_date: String? = null

    @SerializedName("end_date")
    @Expose
    private var end_date: String? = null

    @SerializedName("booking_per_slot")
    @Expose
    private var booking_per_slot = 0

    @SerializedName("slot_duration")
    @Expose
    private var slot_duration = 0

    @SerializedName("state")
    @Expose
    private var state: String? = null

    @SerializedName("address")
    @Expose
    private var address: Address? = null

    @SerializedName("hotel_detail")
    @Expose
    private var hotel_detail: String? = null

    @SerializedName("trunk_show_schedules")
    @Expose
    private var trunk_show_schedules: ArrayList<Trunk_show_schedules?>? = null

    @SerializedName("readable_address")
    @Expose
    private var readable_address: String? = null

    @SerializedName("color_code")
    @Expose
    private var color_code: Color_code? = null

    @SerializedName("formatted_start_date_1")
    @Expose
    private var formatted_start_date_1: String? = null

    @SerializedName("formatted_start_date_2")
    @Expose
    private var formatted_start_date_2: String? = null

    @SerializedName("formatted_end_date_1")
    @Expose
    private var formatted_end_date_1: String? = null

    @SerializedName("formatted_end_date_2")
    @Expose
    private var formatted_end_date_2: String? = null

    @SerializedName("booking_count")
    @Expose
    private var booking_count = 0

    @SerializedName("slots_available_count")
    @Expose
    private var slots_available_count = 0

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String?) {
        this.code = code
    }

    fun getStart_date(): String? {
        return start_date
    }

    fun setStart_date(start_date: String?) {
        this.start_date = start_date
    }

    fun getEnd_date(): String? {
        return end_date
    }

    fun setEnd_date(end_date: String?) {
        this.end_date = end_date
    }

    fun getBooking_per_slot(): Int {
        return booking_per_slot
    }

    fun setBooking_per_slot(booking_per_slot: Int) {
        this.booking_per_slot = booking_per_slot
    }

    fun getSlot_duration(): Int {
        return slot_duration
    }

    fun setSlot_duration(slot_duration: Int) {
        this.slot_duration = slot_duration
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address?) {
        this.address = address
    }

    fun getHotel_detail(): String? {
        return hotel_detail
    }

    fun setHotel_detail(hotel_detail: String?) {
        this.hotel_detail = hotel_detail
    }

    fun getTrunk_show_schedules(): ArrayList<Trunk_show_schedules?>? {
        return trunk_show_schedules
    }

    fun setTrunk_show_schedules(trunk_show_schedules: ArrayList<Trunk_show_schedules?>?) {
        this.trunk_show_schedules = trunk_show_schedules
    }

    fun getReadable_address(): String? {
        return readable_address
    }

    fun setReadable_address(readable_address: String?) {
        this.readable_address = readable_address
    }

    fun getColor_code(): Color_code? {
        return color_code
    }

    fun setColor_code(color_code: Color_code?) {
        this.color_code = color_code
    }

    fun getFormatted_start_date_1(): String? {
        return formatted_start_date_1
    }

    fun setFormatted_start_date_1(formatted_start_date_1: String?) {
        this.formatted_start_date_1 = formatted_start_date_1
    }

    fun getFormatted_start_date_2(): String? {
        return formatted_start_date_2
    }

    fun setFormatted_start_date_2(formatted_start_date_2: String?) {
        this.formatted_start_date_2 = formatted_start_date_2
    }

    fun getFormatted_end_date_1(): String? {
        return formatted_end_date_1
    }

    fun setFormatted_end_date_1(formatted_end_date_1: String?) {
        this.formatted_end_date_1 = formatted_end_date_1
    }

    fun getFormatted_end_date_2(): String? {
        return formatted_end_date_2
    }

    fun setFormatted_end_date_2(formatted_end_date_2: String?) {
        this.formatted_end_date_2 = formatted_end_date_2
    }

    fun getBooking_count(): Int {
        return booking_count
    }

    fun setBooking_count(booking_count: Int) {
        this.booking_count = booking_count
    }

    fun getSlots_available_count(): Int {
        return slots_available_count
    }

    fun setSlots_available_count(slots_available_count: Int) {
        this.slots_available_count = slots_available_count
    }
}