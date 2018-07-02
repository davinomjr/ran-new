package com.davinomjr.ran.presentation.viewmodel

import com.davinomjr.common.domain.Either
import com.davinomjr.common.domain.Failure
import com.davinomjr.common.interactor.UseCase
import com.davinomjr.ran.domain.entities.LoginData
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/01/2018 20:13
 */

class ValidateLogin @Inject constructor()
    : UseCase<Boolean, LoginData>() {

    override suspend fun run(loginData: LoginData): Either<Failure, Boolean> {
        if(loginData.email.isEmpty() || loginData.password.isEmpty()){
            return Either.Right(false)
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(loginData.email).matches()){
            return Either.Right(false)
        }
        else if(loginData.password.length < 6 || loginData.password.length > 20){
            return Either.Right(false)
        }

        return Either.Right(true)
    }
}