package com.tailwebs.tailwebsappointmentapp.retrofitapi

import com.tailwebs.tailwebsappointmentapp.model.ForgotPassword
import com.tailwebs.tailwebsappointmentapp.model.Login
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {
    @FormUrlEncoded
    @POST("sessions/create")
    fun doLogin(
        @Field("sales_person[email]") email: String?,
        @Field("sales_person[password]") password: String?
    ): Call<Login?>?

    @FormUrlEncoded
    @POST("passwords.json")
    fun doForgotPassLogin(@Field("sales_person[email]") phone: String?): Call<ForgotPassword?>?


    @GET("sales_person_shops.json")
    fun getShops(): Call<Sales_person_shops>

    @GET("trunk_shows.json")
    fun getTrunkShows(@Query("action_type") action_type: String?): Call<Trunk_shows>


}