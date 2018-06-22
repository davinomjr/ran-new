package com.davinomjr.ran.presentation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.davinomjr.ran.App
import com.davinomjr.ran.di.AppComponent

/*
 * Created by Davino Junior - dmtsj@{cin.ufpe.br, gmail.com}
 * at 06/20/2018 23:37
 */
 
open class BaseFragment() : Fragment() {

    val appComponent: AppComponent by lazy {
        (activity?.application as App).appComponent
    }


}