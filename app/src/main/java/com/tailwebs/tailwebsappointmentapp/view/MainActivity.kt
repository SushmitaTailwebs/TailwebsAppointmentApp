package com.tailwebs.tailwebsappointmentapp.view

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.model.Login
import com.tailwebs.tailwebsappointmentapp.retrofitapi.ApiClient
import com.tailwebs.tailwebsappointmentapp.retrofitapi.RetrofitClientForLogin
import com.tailwebs.tailwebsappointmentapp.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , View.OnClickListener {
    @BindView(R.id.textInputLayoutEmailId)
    @JvmField
    var textInputLayoutEmail: TextInputLayout? = null

    @BindView(R.id.textInputLayoutPassId)
    @JvmField
    var textInputLayoutPass: TextInputLayout? = null

    @BindView(R.id.loginId)
    @JvmField
    var loginBt: Button? = null

    @BindView(R.id.forgotPassId)
    @JvmField
    var forgotPass: TextView? = null

    @BindView(R.id.passId)
    @JvmField
    var textInputEditTextPass: TextInputEditText? = null

    @BindView(R.id.emailId)
    @JvmField
    var textInputEditTextEmail: TextInputEditText? = null
    private var mProgressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        loginBt!!.setOnClickListener(this)
        forgotPass!!.setOnClickListener(this)
        textInputEditTextEmail!!.setOnTouchListener { v, event ->
            textInputLayoutEmail!!.isHintEnabled = true
            textInputLayoutEmail!!.setBackgroundColor(resources.getColor(R.color.white))
            textInputEditTextEmail!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        }

        textInputEditTextPass!!.setOnTouchListener { v, event ->
            textInputLayoutPass!!.isHintEnabled = true
            textInputLayoutPass!!.setBackgroundColor(resources.getColor(R.color.white))
            textInputEditTextPass!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        }
    }
    private fun ValidateEmail(): Boolean {
        val emailInput = textInputLayoutEmail!!.editText!!.text.toString()
        return if (emailInput.isEmpty()) {
            textInputLayoutEmail!!.error = "Enter email"
            textInputLayoutEmail!!.isHintEnabled = false
            textInputEditTextEmail!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        } else {
            textInputLayoutEmail!!.error = null
            textInputLayoutEmail!!.isHintEnabled = true
            textInputEditTextEmail!!.background = resources.getDrawable(R.drawable.bg_shape)
            if (isValidEmail(emailInput)) {
                true
            } else {
                textInputLayoutEmail!!.error = "Enter valid email"
                false
            }
        }
    }

    private fun ValidatePass(): Boolean {
        val emailInput = textInputLayoutPass!!.editText!!.text.toString()
        return if (emailInput.isEmpty()) {
            textInputLayoutPass!!.error = "Enter password"
            textInputLayoutPass!!.isHintEnabled = false
            textInputEditTextPass!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        } else {
            textInputLayoutPass!!.error = null
            textInputLayoutPass!!.isHintEnabled = true
            textInputEditTextPass!!.background = resources.getDrawable(R.drawable.bg_shape)
            true
        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    private fun goToDashboard() {
        if (!ValidateEmail() or !ValidatePass()) {
            return
        }
        if (NetworkUtils.haveNetworkConnection(this@MainActivity)) {
            showProgressDialog(this@MainActivity)
            logincall()
        } else {
            Uiutils.showAlertDialogWithOKButton(this,
                getString(R.string.error_no_internet),
                DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
        }
    }

    private fun logincall() {
        try {
            val email = textInputLayoutEmail!!.editText!!.text.toString()
            val pass = textInputLayoutPass!!.editText!!.text.toString()
            val apiService: ApiClient =
                RetrofitClientForLogin.getClient()!!.create(ApiClient::class.java)
            val call: Call<Login?>? = apiService.doLogin(email, pass)
            call!!.enqueue(object : Callback<Login?> {
                @RequiresApi(api = Build.VERSION_CODES.M)
                override fun onResponse(call: Call<Login?>, response: Response<Login?>) {
                    if (response.body() != null) {
                        if (response.isSuccessful()) {
                            if (response.body()!!.isSuccess()) {
                                hideProgressDialog()
                                SharedPreferenceUtils.saveValue(this@MainActivity,Constants.KEY_SECRET,response.body()!!.getSecret())
                                SharedPreferenceUtils.saveValue(this@MainActivity,Constants.KEY_SECRET_ID,response.body()!!.getSecretId())
                                SharedPreferenceUtils.saveValue(this@MainActivity,Constants.KEY_SALES_PERSON_NAME,response.body()!!.getSales_person()!!.getName())
                                GlobalValue.secret = response.body()!!.getSecret()
                                GlobalValue.secret_id = response.body()!!.getSecretId()
                                SharedPreferenceUtils.setUserLoggedIn(this@MainActivity,true,email)
                                val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                hideProgressDialog()
                                NetworkUtils.handleErrorsForAPICalls(this@MainActivity, response.body()!!.getErrors(),response.body()!!.getNotice())
                                Toast.makeText(this@MainActivity,"Error: " + response.body()!!.getErrors(),Toast.LENGTH_SHORT ).show()
                            }
                        } else {
                            hideProgressDialog()
                            NetworkUtils.handleErrorsCasesForAPICalls(this@MainActivity,response.code(),response.body()!!.getErrors())
                            //clearFields();
                            Toast.makeText(this@MainActivity,"Error: " + response.body()!!.getErrors(),Toast.LENGTH_SHORT ).show()
                        }
                    } else {
                        hideProgressDialog()
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                        NetworkUtils.handleErrorsForAPICalls(this@MainActivity, null, null)
                    }
                }

                override fun onFailure(call: Call<Login?>, t: Throwable) {
                    hideProgressDialog()
                    NetworkUtils.handleErrorsForAPICalls(this@MainActivity, null, null)
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        } catch (e: NullPointerException) {
            print("Caught the NullPointerException")
        } catch (e: Exception) {
            print("Caught the Exception")
        }
    }
    override fun onClick(v: View?) {
      
        when (v!!.id) {
            R.id.loginId -> goToDashboard()
            R.id.forgotPassId -> if (NetworkUtils.haveNetworkConnection(this)) {
                val intent = Intent(this, ForgotPasswordActivity::class.java)
               startActivity(intent)
            } else {
                Uiutils.showAlertDialogWithOKButton(this,
                    getString(R.string.error_no_internet),
                    DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
            }
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