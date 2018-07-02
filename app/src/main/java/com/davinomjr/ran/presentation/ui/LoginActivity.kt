package com.davinomjr.ran.presentation.ui

import android.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.davinomjr.common.ui.BaseActivity
import com.davinomjr.common.viewmodel.BaseViewModel
import com.davinomjr.ran.R
import com.davinomjr.ran.presentation.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.login_layout, LoginFragment.newInstance())
                    .commit()
        }

    }

}
