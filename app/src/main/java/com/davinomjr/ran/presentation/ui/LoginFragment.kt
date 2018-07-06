package com.davinomjr.ran.presentation.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.view.*

import com.davinomjr.ran.R
import com.davinomjr.ran.databinding.FragmentLoginBinding
import com.davinomjr.ran.domain.entities.User
import com.davinomjr.ran.presentation.viewmodel.LoginViewModel
import com.davinomjr.ran.util.extension.showAlert
import com.davinomjr.ran.util.extension.showToast
import com.davinomjr.ran.util.extension.viewModel

class LoginFragment : BaseFragment() {

    private val TAG = LoginFragment::class.java.simpleName

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
        binding.root.link_signup.setOnClickListener(::onSignUpClick)
        return binding.root
    }

    fun onLoginClick(view: View?) {
        binding.viewModel!!.handleLoginClick()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doAfterTerminate { hideProgress() }
                .subscribe(object: SingleObserver<User> {
                    override fun onSubscribe(d: Disposable) {
                        d.dispose()
                    }
                    override fun onSuccess(user: User) {
                        Log.i(TAG, "onLoginClick: onSuccess()")
                    }
                    override fun onError(e: Throwable) {
                        this@LoginFragment.context!!.showAlert(e.message.toString())
                    }
                })

    }

    fun onSignUpClick(view: View?){
        // Move to SignUpActivity
    }

    fun showProgress(){

    }

    fun hideProgress(){

    }
}

