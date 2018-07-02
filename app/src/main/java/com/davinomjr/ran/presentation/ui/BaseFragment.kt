package com.davinomjr.ran.presentation.ui

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import com.davinomjr.ran.App
import com.davinomjr.ran.di.AppComponent
import javax.inject.Inject

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 23:37
 */
 
abstract class BaseFragment : Fragment() {

    val appComponent: AppComponent by lazy (mode = LazyThreadSafetyMode.NONE){
        (activity?.application as App).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}