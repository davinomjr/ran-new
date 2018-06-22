package com.davinomjr.ran.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.util.Log
import com.davinomjr.common.ui.BaseActivity
import com.davinomjr.common.viewmodel.BaseViewModel
import com.davinomjr.ran.presentation.ui.BaseFragment

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/21/2018 22:15
 */
 
class LoginViewModel : BaseViewModel(){

    companion object {
        fun create(fragment: BaseFragment): LoginViewModel = ViewModelProviders.of(fragment).get(LoginViewModel::class.java)
    }

    val TAG = LoginViewModel::class.java.simpleName

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun handleLoginClick(){
        Log.i(TAG,"current email = ${email.value} and current pass = ${password.value}")
    }

}