package com.tailwebs.tailwebsappointmentapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtils {
    companion object {
        val PREFS_NAME = "appointment"

//    fun SharedPreferenceUtils() {
//         super()
//    }


        fun saveValue(context: Context, KEY_NAME: String?, text: String?) {
            try {
                val settings: SharedPreferences
                val editor: SharedPreferences.Editor
                settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) //1
                editor = settings.edit() //2
                editor.putString(KEY_NAME, text) //3
                editor.commit() //4
            } catch (e: NullPointerException) {
                print("Caught the NullPointerException")
            } catch (e: Exception) {
                print("Caught the Exception")
            }
        }


        fun getValue(context: Context, KEY_NAME: String?): String? {
            val settings: SharedPreferences
            var text: String? = null
            try {
                settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                text = settings.getString(KEY_NAME, null)
            } catch (e: NullPointerException) {
                print("Caught the NullPointerException")
            } catch (e: Exception) {
                print("Caught the Exception")
            }
            return text
        }

        fun setUserLoggedIn(context: Context, loggedIn: Boolean, provider: String?) {
            try {
                val editor = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putBoolean(Constants.KEY_LOGGED_STATUS, loggedIn)
                editor.putString(Constants.KEY_PROVIDER, provider)
                editor.apply()
            } catch (e: NullPointerException) {
                print("Caught the NullPointerException")
            } catch (e: Exception) {
                print("Caught the Exception")
            }
        }

        fun isUserLoggedIn(context: Context?): Boolean {
            var status = false
            val prefs: SharedPreferences
            try {
                if (null != context) {
                    prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                    status = prefs.getBoolean(Constants.KEY_LOGGED_STATUS, false)
                }
            } catch (ex: Exception) {
            }
            return status
        }
    }
}