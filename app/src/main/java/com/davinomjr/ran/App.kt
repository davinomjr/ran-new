package com.davinomjr.ran

import android.app.Application
import com.davinomjr.ran.di.AppModule
import com.davinomjr.ran.di.DaggerAppComponent

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 22:26
 */

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}