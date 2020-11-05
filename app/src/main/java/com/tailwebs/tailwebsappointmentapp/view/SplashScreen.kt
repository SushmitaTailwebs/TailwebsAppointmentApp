package com.tailwebs.tailwebsappointmentapp.view

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.utils.Constants
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import com.tailwebs.tailwebsappointmentapp.utils.SharedPreferenceUtils
import java.util.*

class SplashScreen : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val tz = TimeZone.getDefault()
        GlobalValue.http_locale = "en"
        GlobalValue.http_timezone = tz.id
        val manager = this.packageManager
        var info: PackageInfo? = null
        try {
            info = manager.getPackageInfo(this.packageName, PackageManager.GET_ACTIVITIES)
            GlobalValue.app_version = info.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            if (SharedPreferenceUtils.isUserLoggedIn(this@SplashScreen)) {
                GlobalValue.secret =
                    SharedPreferenceUtils.getValue(this@SplashScreen, Constants.KEY_SECRET)
                GlobalValue.secret_id =
                    SharedPreferenceUtils.getValue(this@SplashScreen, Constants.KEY_SECRET_ID)
                val mainIntent = Intent(this@SplashScreen, DashboardActivity::class.java)
                startActivity(mainIntent)
            } else {
                val mainIntent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(mainIntent)
            }
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
