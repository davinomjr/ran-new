package com.davinomjr.firebase

import android.app.Activity
import android.content.Context
import android.util.Log
import com.davinomjr.ran.domain.entities.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton
import javax.security.auth.login.LoginException

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 07/04/2018 22:23
 */

class FirebaseLogin @Inject constructor() {

    val database = FirebaseDatabase.getInstance()
    val auth = FirebaseAuth.getInstance()

    fun createNewUser(user: User) : Single<User> {
        return Single.create { emitter ->
            auth.createUserWithEmailAndPassword(user.email, user.password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) {
                            emitter.onError(Exception("Error creating user"))
                        } else {
                            val firebaseUser: FirebaseUser? = auth.currentUser
                            val profileUpdates = UserProfileChangeRequest.Builder().setDisplayName(user.name).build()
                            firebaseUser!!.updateProfile(profileUpdates)
                            auth.signInWithEmailAndPassword(user.email, user.password)
                                    .addOnCompleteListener { task ->
                                        if (!task.isSuccessful) {
                                            emitter.onError(Exception("Error signing in after creating user"))
                                        } else {
                                            createUserReference(user)
                                            emitter.onSuccess(user)
                                        }
                                    }
                        }
                    }
        }
    }

    fun signIn(user: User) : Single<User> {
        return Single.create{ emitter ->
            auth.signInWithEmailAndPassword(user.email, user.password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) {
                            if (it.exception is FirebaseAuthInvalidUserException || it.exception is FirebaseAuthInvalidCredentialsException) {
                                emitter.onError(LoginException("Credenciais invalidas"))
                            } else {
                                emitter.onError(LoginException("Erro ao logar"))
                            }
                        } else {
                            user.userId = auth.currentUser!!.uid
                            emitter.onSuccess(user)
                        }


                    }

        }
    }


    private fun createUserReference(user: User) {
        val userReference = database.getReference("users")
        val key = auth.currentUser!!.uid
        user.userId = key
        userReference.child(key).setValue(user)
    }
}
