package com.davinomjr.ran.domain.interactor.login

import com.davinomjr.firebase.FirebaseLogin
import com.davinomjr.ran.domain.entities.User
import com.davinomjr.ran.domain.entities.UserData
import io.reactivex.Single
import java.lang.reflect.Constructor
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/05/2018 12:54
 */
 
 class SignInLogin @Inject constructor(val firebaseLogin: FirebaseLogin) {

     fun execute(userData: UserData) : Single<User>{
         return firebaseLogin.signIn(User(userData))
     }
 }