package com.davinomjr.ran.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.davinomjr.common.viewmodel.BaseViewModel
import com.davinomjr.ran.domain.entities.UserData
import com.davinomjr.ran.domain.entities.User
import com.davinomjr.ran.domain.interactor.login.SignInLogin
import com.davinomjr.ran.domain.interactor.login.SignUpLogin
import io.reactivex.Single
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/21/2018 22:15
 */
 
class LoginViewModel
@Inject constructor(private val signUpInteractor: SignUpLogin,
                    private val signInInteractor: SignInLogin,
                    private val validateLoginInteractor: ValidateLogin)
    : BaseViewModel(){


    val TAG = LoginViewModel::class.java.simpleName

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun handleLoginClick() : Single<User> {
        val userData = UserData(email.value.toString(), password.value.toString())
        return validateLoginInteractor.execute(userData)
                                      .flatMap { signInInteractor.execute(userData) }
    }

    fun handleSignUpClick() : Single<User> {
        val userData = UserData(email.value.toString(), password.value.toString())
        return validateLoginInteractor.execute(userData)
                .flatMap { signUpInteractor.execute(userData) }
    }
}