package com.davinomjr.ran.di

import com.davinomjr.ran.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 17:47
 */

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() : App = app
}