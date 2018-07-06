package com.davinomjr.ran.domain.entities

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/04/2018 22:30
 */

data class User(var userId: String, val name: String, val email: String, val password: String){

    constructor(name: String, email: String, password: String) : this("", name,email,password)
    constructor(userData: UserData) : this(userData.name, userData.email, userData.password)
}