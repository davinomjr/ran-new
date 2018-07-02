package com.davinomjr.ran.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.davinomjr.common.viewmodel.BaseViewModel
import com.davinomjr.ran.domain.entities.LoginData
import com.davinomjr.ran.domain.interactor.login.SignUpLogin
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/21/2018 22:15
 */
 
class LoginViewModel
@Inject constructor(private val signInLoginInteractor: SignUpLogin,
                    private val validateLoginInteractor: ValidateLogin)
    : BaseViewModel(){


    val TAG = LoginViewModel::class.java.simpleName

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun handleLoginClick(){
        val loginData = LoginData(email.value.toString(), password.value.toString())
        validateLoginInteractor.execute({it.either(::handleFailure, ::signIn)}, loginData)
    }

    fun signIn(result: Boolean){
        if(result){
            val loginData = LoginData(email.value.toString(), password.value.toString())
            signInLoginInteractor.execute({it.either(::handleFailure, {})}, loginData)
        }
    }
}