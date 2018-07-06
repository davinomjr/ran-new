package com.davinomjr.ran.util.validation

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/04/2018 19:26
 */

class Validator {

    companion object {
        fun isEmailValid(email: String) = !email.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        fun isPasswordValid(password: String) = !password.isEmpty() && password.length > 6 && password.length < 20
    }
}