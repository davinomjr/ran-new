package com.davinomjr.ran.util.validation

import android.databinding.BindingAdapter
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/01/2018 22:54
 */

@BindingAdapter("validateEmail")
fun validateEmail(editText: EditText, errorMessage: String){
    addValidationRule(editText,errorMessage,{ !it.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()})
}

@BindingAdapter("validatePassword")
fun validatePassword(editText: EditText, errorMessage: String){
    addValidationRule(editText, errorMessage, { !it.isEmpty() })
}


private fun addValidationRule(editText: EditText, errorMessage: String, validationRule: (String) -> Boolean){
    editText.addTextChangedListener(object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val text = s.toString()
            if(!validationRule.invoke(text)){
                editText.error = errorMessage
            }
        }
    })
}