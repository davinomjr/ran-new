package com.davinomjr.ran.util.extension

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/06/2018 17:26
 */
 
fun Context.showToast(message: String, toastLength: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, toastLength).show()
fun Context.showAlert(message: String, yesCallback: (dialog: DialogInterface) -> Unit = {}, noCallback: (dialog: DialogInterface) -> Unit = {}) {
    this.alert(message) {
        yesButton(yesCallback)
        noButton(noCallback)
    }.show()
}
