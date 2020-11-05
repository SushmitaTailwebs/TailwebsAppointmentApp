package com.tailwebs.tailwebsappointmentapp.utils

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.util.Log
import com.google.gson.internal.LinkedTreeMap
import java.util.*

class NetworkUtils {
    companion object {
        fun haveNetworkConnection(context: Context): Boolean {
            var haveConnectedWifi = false
            var haveConnectedMobile = false
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    return true.also { haveConnectedWifi = it }
                } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    // check NetworkInfo subtype
                    return when (activeNetwork.subtype) {
                        TelephonyManager.NETWORK_TYPE_GPRS -> {
                            Log.d("Internet drools 2g", " NETWORK_TYPE_GPRS")
                            false.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_EDGE -> {
                            Log.d("Internet drools 2g", "NETWORK_TYPE_EDGE")
                            false.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_CDMA -> {
                            Log.d("Internet drools 2g", "NETWORK_TYPE_CDMA")
                            false.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_1xRTT -> {
                            Log.d("Internet drools 2g", "NETWORK_TYPE_1xRTT")
                            false.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_IDEN -> {
                            Log.d("Internet drools 2g", "NETWORK_TYPE_IDEN")
                            false.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_UMTS -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_UMTS")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_EVDO_0 -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_EVDO_0")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_EVDO_A -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_EVDO_A")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_HSDPA -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_HSDPA")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_HSUPA -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_HSUPA")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_HSPA -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_HSPA")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_EVDO_B -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_EVDO_B")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_EHRPD -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_EHRPD")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_HSPAP -> {
                            Log.d("Internet drools 3g", "NETWORK_TYPE_HSPAP")
                            true.also { haveConnectedMobile = it }
                        }
                        TelephonyManager.NETWORK_TYPE_LTE -> {
                            Log.d("Internet drools 4g", "NETWORK_TYPE_LTE")
                            true.also { haveConnectedMobile = it }
                        }
                        else -> false.also { haveConnectedMobile = it }
                    }
                }
            } else {
                // not connected to the internet
                haveConnectedMobile = false
                haveConnectedWifi = false
            }
            return haveConnectedWifi || haveConnectedMobile
        }

        fun handleErrorsForAPICalls(context: Context?, errors: Any?, notice: Any?) {
            Log.e("Evare = ", "--$notice--$errors")
            try {
                if (errors != null && notice != null) {
                    val errorTxt: String = parseError(errors)
                    val msg = """
                $errorTxt
                $notice
                """.trimIndent()
                    Uiutils.showAlertDialogWithOKButton(
                        context!!, msg,
                        DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
                } else if (errors != null) {
                    Uiutils.showAlertDialogWithOKButton(
                        context!!, parseError(errors),
                        DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
                } else if (notice != null && !notice.toString().isEmpty()) {
                    Uiutils.showAlertDialogWithOKButton(
                        context!!, notice as String?,
                        DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
                } else {
                    Uiutils.showAlertDialogWithOKButton(
                        context!!,
                        "Error message" + errors.toString() + " - notice - " + notice.toString(),
                        DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
                }
            } catch (e: java.lang.NullPointerException) {
                print("Caught the NullPointerException")
            }
        }

        fun parseError(`object`: Any?): String {
            return try {
                if (`object` != null) {
                    try {
                        val errorMap = `object` as LinkedTreeMap<String, Any>
                        for ((key, value) in errorMap) {
                            return try {
                                val values = value as ArrayList<String>
                                Log.e("Key = ", "$key, Value = $value")
                                values[0]
                            } catch (e: Exception) {
                                val values = value as Array<String>
                                Log.e("Key = ", "$key, Value = $value")
                                values[0]
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        return if (`object` is ArrayList<*>) {
                            `object`[0].toString()
                        } else {
                            `object` as String
                        }
                    }
                }
                ""
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }

        fun handleErrorsCasesForAPICalls(context: Context?, responseCode: Int, errors: Any?) {
            try {
                Log.e("responseCode = ", "--$responseCode")
                when (responseCode) {
                    400 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    401 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    404 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    405 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    500 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    503 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    426 -> {
                        Log.e("Evare", "-forceupdate required-$responseCode")
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                    460 -> {
                        handleErrorsForAPICalls(context, errors, responseCode)
                    }
                }
            } catch (e: NullPointerException) {
                print("Caught the NullPointerException")
            }
        }
    }
}