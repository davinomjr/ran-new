package com.davinomjr.ran.di

import com.davinomjr.common.di.modules.ViewModelModule
import com.davinomjr.ran.App
import dagger.Component

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 22:28
 */
 
 @Component(modules = [
    AppModule::class,
    ViewModelModule::class
 ])
interface AppComponent {
     fun inject(app: App)
 }