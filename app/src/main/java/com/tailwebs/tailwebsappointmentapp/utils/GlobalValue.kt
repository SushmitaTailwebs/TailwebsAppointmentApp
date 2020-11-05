package com.tailwebs.tailwebsappointmentapp.utils

import com.tailwebs.tailwebsappointmentapp.model.Appointments
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops_List
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows_list
import java.util.*

class GlobalValue {
    companion object {

        var http_locale: String? = null
        var http_timezone: String? = null
        var app_version: String? = null
        var secret: String? = null
        var secret_id: String? = null
        @JvmStatic var ShopName = "Select"
        @JvmStatic var shops_lists: ArrayList<Sales_person_shops_List>? = null
        var shopsLists: ArrayList<Sales_person_shops_List?>? = null
        @JvmStatic var trunk_shows_lists: ArrayList<Trunk_shows_list?>? = null
        var trunkShowsLists: ArrayList<Trunk_shows_list?>? = null
        var appointmentsArrayList: ArrayList<Appointments>? = null
        var appointmentsArrayListForTrunkShow: ArrayList<Appointments>? = null
        @JvmStatic var isSelectedShop = false
        @JvmStatic var isSelectedTrunkShow = false
        @JvmStatic var selectedId = ""
        @JvmStatic var isFromAdapter = false
    }
}