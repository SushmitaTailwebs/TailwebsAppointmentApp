package com.tailwebs.tailwebsappointmentapp.view

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.controller.AdapterForShpoAndTrunkShow
import com.tailwebs.tailwebsappointmentapp.controller.AdapterForTrunkShowAndShopDetails
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops_List
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows_list
import com.tailwebs.tailwebsappointmentapp.retrofitapi.ApiClient
import com.tailwebs.tailwebsappointmentapp.retrofitapi.RetrofitClientForHeaders
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import com.tailwebs.tailwebsappointmentapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ShowShopsAndTrunkShowDetails : AppCompatActivity() {
    @BindView(R.id.rvId)
    @JvmField
    var recyclerView: RecyclerView? = null
    private var mProgressDialog: ProgressDialog? = null
    private var shopsArrayList: ArrayList<Sales_person_shops_List?>? = null
    private var trunkShowsArrayList: ArrayList<Trunk_shows_list?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_shops_and_trunk_show_details)
        ButterKnife.bind(this)
        shopsArrayList = ArrayList()
        trunkShowsArrayList = ArrayList()
        init()
    }
    private fun init() {
        showProgressDialog(this@ShowShopsAndTrunkShowDetails)
        fetchShopsDetails()
    }

    private fun fetchTrunkShowDetails() {
        try {
            val apiService: ApiClient =
                RetrofitClientForHeaders.getClient(this@ShowShopsAndTrunkShowDetails)!!.create(
                    ApiClient::class.java
                )
            val call: Call<Trunk_shows> = apiService.getTrunkShows("active")
            call.enqueue(object : Callback<Trunk_shows> {
                @RequiresApi(api = Build.VERSION_CODES.M)
                override fun onResponse(
                    call: Call<Trunk_shows>,
                    response: Response<Trunk_shows>
                ) {
                    if (response.body() != null) {
                        if (response.isSuccessful()) {
                            if (response.body()!!.isSuccess()) {
                                hideProgressDialog()
                                response.body()!!.getTrunk_shows()?.let {
                                    trunkShowsArrayList!!.addAll(
                                        it
                                    )
                                }
                             //  trunkShowsArrayList!!.addAll(response.body()!!.getTrunk_shows())
                                val linearLayoutManager =
                                    LinearLayoutManager(this@ShowShopsAndTrunkShowDetails)
                                GlobalValue.trunkShowsLists = ArrayList()
                                GlobalValue.shopsLists = ArrayList()
                                shopsArrayList?.let { GlobalValue.shopsLists!!.addAll(it) }
                                trunkShowsArrayList?.let { GlobalValue.trunkShowsLists!!.addAll(it) }
                                val adapter = AdapterForTrunkShowAndShopDetails(this@ShowShopsAndTrunkShowDetails,shopsArrayList,
                                    trunkShowsArrayList!!
                                )
                                recyclerView!!.layoutManager = linearLayoutManager
                                recyclerView!!.adapter = adapter
                            } else {
                                hideProgressDialog()
                                NetworkUtils.handleErrorsForAPICalls(
                                    this@ShowShopsAndTrunkShowDetails,
                                    response.body()!!.getErrors(),
                                    response.body()!!.getNotice()
                                )
                                Toast.makeText(
                                    this@ShowShopsAndTrunkShowDetails,
                                    "Error: " + response.body()!!.getErrors(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            hideProgressDialog()
                            NetworkUtils.handleErrorsCasesForAPICalls(
                                this@ShowShopsAndTrunkShowDetails,
                                response.code(),
                                response.body()!!.getErrors()
                            )
                            //clearFields();
                            Toast.makeText(
                                this@ShowShopsAndTrunkShowDetails,
                                "Error: " + response.body()!!.getErrors(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        hideProgressDialog()
                        Toast.makeText(
                            this@ShowShopsAndTrunkShowDetails,
                            "Error",
                            Toast.LENGTH_SHORT
                        ).show()
                        NetworkUtils.handleErrorsForAPICalls(
                            this@ShowShopsAndTrunkShowDetails,
                            null,
                            null
                        )
                    }
                }

                override fun onFailure(call: Call<Trunk_shows?>, t: Throwable) {
                    hideProgressDialog()
                    NetworkUtils.handleErrorsForAPICalls(
                        this@ShowShopsAndTrunkShowDetails,
                        null,
                        null
                    )
                    Toast.makeText(this@ShowShopsAndTrunkShowDetails, "Error", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        } catch (e: NullPointerException) {
            print("Caught the NullPointerException")
        } catch (e: Exception) {
            print("Caught the Exception")
        }
    }

    private fun fetchShopsDetails() {
        try {
            val apiService: ApiClient =
                RetrofitClientForHeaders.getClient(this@ShowShopsAndTrunkShowDetails)!!.create(
                    ApiClient::class.java
                )
            val call: Call<Sales_person_shops> = apiService.getShops()
            call!!.enqueue(object : Callback<Sales_person_shops?> {
                @RequiresApi(api = Build.VERSION_CODES.M)
                override fun onResponse(
                    call: Call<Sales_person_shops?>,
                    response: Response<Sales_person_shops?>
                ) {
                    if (response.body() != null) {
                        if (response.isSuccessful()) {
                            if (response.body()!!.isSuccess()) {
                                hideProgressDialog()
                                response.body()!!.getSales_person_shops()?.let {
                                    shopsArrayList!!.addAll(
                                        it
                                    )
                                }
                                fetchTrunkShowDetails()
                            } else {
                                hideProgressDialog()
                                NetworkUtils.handleErrorsForAPICalls(
                                    this@ShowShopsAndTrunkShowDetails,
                                    response.body()!!.getErrors(),
                                    response.body()!!.getNotice()
                                )
                                Toast.makeText(
                                    this@ShowShopsAndTrunkShowDetails,
                                    "Error: " + response.body()!!.getErrors(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            hideProgressDialog()
                            NetworkUtils.handleErrorsCasesForAPICalls(
                                this@ShowShopsAndTrunkShowDetails,
                                response.code(),
                                response.body()!!.getErrors()
                            )
                            //clearFields();
                            Toast.makeText(
                                this@ShowShopsAndTrunkShowDetails,
                                "Error: " + response.body()!!.getErrors(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        hideProgressDialog()
                        Toast.makeText(
                            this@ShowShopsAndTrunkShowDetails,
                            "Error",
                            Toast.LENGTH_SHORT
                        ).show()
                        NetworkUtils.handleErrorsForAPICalls(
                            this@ShowShopsAndTrunkShowDetails,
                            null,
                            null
                        )
                    }
                }

                override fun onFailure(call: Call<Sales_person_shops?>, t: Throwable) {
                    hideProgressDialog()
                    NetworkUtils.handleErrorsForAPICalls(
                        this@ShowShopsAndTrunkShowDetails,
                        null,
                        null
                    )
                    Toast.makeText(this@ShowShopsAndTrunkShowDetails, "Error", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        } catch (e: NullPointerException) {
            print("Caught the NullPointerException")
        } catch (e: Exception) {
            print("Caught the Exception")
        }
    }

    fun showProgressDialog(context: Context) {
        if (!(context as Activity).isFinishing) {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog(context, R.style.DialogCustom)
                mProgressDialog!!.setMessage(context.getString(R.string.loading))
                mProgressDialog!!.setIndeterminate(false)
                mProgressDialog!!.setCancelable(false)
            }
            mProgressDialog!!.show()
        }
    }

    fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }
}


