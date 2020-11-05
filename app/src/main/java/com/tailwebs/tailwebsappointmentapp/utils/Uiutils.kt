package com.tailwebs.tailwebsappointmentapp.utils

import android.R
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.TextView

class Uiutils {
    companion object {
    fun showAlertDialogWithOKButton(
        context: Context,
        msg: String?,
        onClickListener: DialogInterface.OnClickListener?
    ) {
        try {
            val builder = AlertDialog.Builder(context)
            builder.setMessage(msg)
            builder.setPositiveButton("Ok", onClickListener)
            builder.setCancelable(false)
            val alertDialog = builder.create()
            alertDialog.setOnShowListener {
                val btnPositive = alertDialog.getButton(Dialog.BUTTON_POSITIVE)
                val textView =
                    alertDialog.findViewById<View>(R.id.message) as TextView
                val am = context.applicationContext.assets
                textView.textSize = 16f
                btnPositive.textSize = 16f
            }
            alertDialog.show()
        } catch (ex: NullPointerException) {
            print(" Caught the NullPointerException")
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }


        @SuppressLint("ResourceAsColor")
        fun showAlertDialogForForgotPass(
            context: Context,
            msg: String?,
            onClickListener: DialogInterface.OnClickListener?
        ) {
            try {
                val builder = AlertDialog.Builder(context)
                builder.setMessage(msg)
                builder.setPositiveButton(
                   "Back to login",
                    onClickListener
                )
                builder.setCancelable(false)
                val alertDialog = builder.create()
                alertDialog.setOnShowListener {
                    val btnPositive = alertDialog.getButton(Dialog.BUTTON_POSITIVE)
                    btnPositive.setTextColor(R.color.black)
                    val textView =
                        alertDialog.findViewById<View>(R.id.message) as TextView
                    val am = context.applicationContext.assets
                    textView.textSize = 13f
                    btnPositive.textSize = 13f
                }
                alertDialog.show()
            } catch (ex: NullPointerException) {
                print(" Caught the NullPointerException")
            } catch (e: Exception) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        }
    }

}