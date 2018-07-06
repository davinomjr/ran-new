package com.davinomjr.ran.presentation.viewmodel

import com.davinomjr.common.domain.Either
import com.davinomjr.common.domain.Failure
import com.davinomjr.common.interactor.UseCase
import com.davinomjr.ran.domain.entities.UserData
import com.davinomjr.ran.util.validation.Validator
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/01/2018 20:13
 */

class ValidateLogin @Inject constructor() {

    fun execute(userData: UserData): Single<Boolean> {
        return Single.create{
            var valid = true
            if(userData.email.isEmpty() || userData.password.isEmpty()){
                valid = false
            }
            else if(!Validator.isEmailValid(userData.email)){
                valid = false
            }
            else if(!Validator.isPasswordValid(userData.password)){
                valid = false
            }

            it.onSuccess(valid)
        }
    }
}