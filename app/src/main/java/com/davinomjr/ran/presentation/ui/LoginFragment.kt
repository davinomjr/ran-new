package com.davinomjr.ran.presentation.ui


import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.davinomjr.ran.R
import com.davinomjr.ran.databinding.FragmentLoginBinding
import com.davinomjr.ran.presentation.viewmodel.LoginViewModel
import com.davinomjr.ran.util.extension.viewModel
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : BaseFragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var loginViewModel: LoginViewModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        loginViewModel = viewModel()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.let {
            it.viewModel = loginViewModel
            it.setLifecycleOwner(this)
        }

        binding.root.btn_login.setOnClickListener(::onLoginClick)
        return binding.root
    }

    fun onLoginClick(view: View?){
        binding.viewModel!!.handleLoginClick()
    }

}

