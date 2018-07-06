package com.davinomjr.ran.util.extension

import android.view.View
import org.jetbrains.anko.design.snackbar

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/06/2018 17:52
 */

fun View.showSnackbar(message: String) = snackbar(this, message)
fun View.showSnackbar(message: String, clickText: String = "", callback: (View) -> Unit) = snackbar(this, message, clickText, callback)
