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
import com.tailwebs.tailwebsappointmentapp.model.ForgotPassword
import com.tailwebs.tailwebsappointmentapp.retrofitapi.ApiClient
import com.tailwebs.tailwebsappointmentapp.retrofitapi.RetrofitClientForLogin
import com.tailwebs.tailwebsappointmentapp.utils.NetworkUtils
import com.tailwebs.tailwebsappointmentapp.utils.Uiutils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity(), View.OnClickListener {
    @BindView(R.id.submitId)
    @JvmField
    var submit: Button? = null

    @BindView(R.id.textInputLayoutEmailId)
    @JvmField
    var textInputLayoutEmail: TextInputLayout? = null

    @BindView(R.id.backToLoginId)
    @JvmField
    var backToLogin: TextView? = null

    @BindView(R.id.emailId)
    @JvmField
    var email: TextInputEditText? = null


    private var mProgressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        ButterKnife.bind(this)
        backToLogin!!.setOnClickListener(this)
        submit!!.setOnClickListener(this)
        email!!.setOnTouchListener { v, event ->
            textInputLayoutEmail!!.isHintEnabled = true
            textInputLayoutEmail!!.setBackgroundColor(resources.getColor(R.color.white))
            email!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        }
    }
    private fun ValidateEmail(): Boolean {
        val emailInput = textInputLayoutEmail!!.editText!!.text.toString()
        return if (emailInput.isEmpty()) {
            textInputLayoutEmail!!.error = "Enter email"
            textInputLayoutEmail!!.isHintEnabled = false
            email!!.background = resources.getDrawable(R.drawable.bg_shape)
            false
        } else {
            textInputLayoutEmail!!.error = null
            textInputLayoutEmail!!.isHintEnabled = true
            email!!.background = resources.getDrawable(R.drawable.bg_shape)
            if (isValidEmail(emailInput)) {
                true
            } else {
                textInputLayoutEmail!!.error = "Enter valid email"
                false
            }
        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
    private fun logincall() {
        try {
            val email = textInputLayoutEmail!!.editText!!.text.toString()
            val apiService: ApiClient =
                RetrofitClientForLogin.getClient()!!.create(ApiClient::class.java)
            val call: Call<ForgotPassword?>? = apiService.doForgotPassLogin(email)
            call!!.enqueue(object : Callback<ForgotPassword?> {
                @RequiresApi(api = Build.VERSION_CODES.M)
                override fun onResponse(
                    call: Call<ForgotPassword?>,
                    response: Response<ForgotPassword?>
                ) {
                    if (response.body() != null) {
                        if (response.isSuccessful()) {
                            if (response.body()!!.isSuccess()) {
                                hideProgressDialog()
                                Uiutils.showAlertDialogForForgotPass(this@ForgotPasswordActivity,
                                    response.body()!!.getNotice(),
                                    DialogInterface.OnClickListener { dialogInterface, i ->
                                        val intent = Intent(
                                            this@ForgotPasswordActivity,
                                            MainActivity::class.java
                                        )
                                        this@ForgotPasswordActivity.startActivity(intent)
                                        finish()
                                    })
                            } else {
                                NetworkUtils.handleErrorsForAPICalls(
                                    this@ForgotPasswordActivity,
                                    response.body()!!.getErrors(),
                                    response.body()!!.getNotice()
                                )
                                hideProgressDialog()
                                Toast.makeText(
                                    this@ForgotPasswordActivity,
                                    "Error: " + response.body()!!.getErrors(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            hideProgressDialog()
                            NetworkUtils.handleErrorsCasesForAPICalls(
                                this@ForgotPasswordActivity,
                                response.code(),
                                response.body()!!.getErrors()
                            )
                            //clearFields();
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Error: " + response.body()!!.getErrors(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        hideProgressDialog()
                        Toast.makeText(this@ForgotPasswordActivity, "Error", Toast.LENGTH_SHORT)
                            .show()
                        NetworkUtils.handleErrorsForAPICalls(
                            this@ForgotPasswordActivity,
                            null,
                            null
                        )
                    }
                }

                override fun onFailure(call: Call<ForgotPassword?>, t: Throwable) {
                    hideProgressDialog()
                    NetworkUtils.handleErrorsForAPICalls(this@ForgotPasswordActivity, null, null)
                    Toast.makeText(this@ForgotPasswordActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        } catch (e: NullPointerException) {
            print("Caught the NullPointerException")
        } catch (e: Exception) {
            print("Caught the Exception")
        }
    }
    private fun callForgotPassApi() {
        if (!ValidateEmail()) {
            return
        }
        if (NetworkUtils.haveNetworkConnection(this@ForgotPasswordActivity)) {
            showProgressDialog(this@ForgotPasswordActivity)
            logincall()
        } else {
            Uiutils.showAlertDialogWithOKButton(this@ForgotPasswordActivity,
                getString(R.string.error_no_internet),
                DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.submitId -> callForgotPassApi()
            R.id.backToLoginId -> {
                val intent = Intent(this@ForgotPasswordActivity, MainActivity::class.java)
                startActivity(intent)
                fileList()
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