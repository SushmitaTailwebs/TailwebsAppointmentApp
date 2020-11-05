package com.tailwebs.tailwebsappointmentapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import butterknife.BindView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import com.tailwebs.tailwebsappointmentapp.view.bottonview.AppointmentFragment
import com.tailwebs.tailwebsappointmentapp.view.bottonview.HomeFragment
import com.volcaniccoder.bottomify.BottomifyNavigationView
import com.volcaniccoder.bottomify.OnNavigationItemChangeListener
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private val appointmentFragment =   AppointmentFragment()
    private val homeFragment =   HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        if(GlobalValue.isFromAdapter){
            replaceFragment(appointmentFragment)
        }else{
            replaceFragment(homeFragment)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_home -> {

                replaceFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_appointment -> {
                replaceFragment(appointmentFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_customer -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}