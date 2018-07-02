package com.davinomjr.ran.di

import com.davinomjr.common.viewmodel.BaseViewModel
import com.davinomjr.ran.App
import com.davinomjr.ran.di.module.LoginModule
import com.davinomjr.ran.di.module.ViewModelModule
import com.davinomjr.ran.presentation.ui.BaseFragment
import com.davinomjr.ran.presentation.ui.LoginFragment
import dagger.Component
import javax.inject.Singleton

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 22:28
 */

 @Singleton
 @Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    LoginModule::class
 ])
interface AppComponent {
     fun inject(app: App)
     fun inject(fragment: LoginFragment)
 }