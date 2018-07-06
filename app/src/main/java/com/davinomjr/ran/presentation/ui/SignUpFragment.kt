package com.davinomjr.ran.presentation.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davinomjr.ran.R
import com.davinomjr.ran.databinding.FragmentSignUpBinding
import com.davinomjr.ran.domain.entities.User
import com.davinomjr.ran.presentation.viewmodel.LoginViewModel
import com.davinomjr.ran.util.extension.*
import com.google.android.gms.common.oob.SignUp
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUpFragment : BaseFragment() {

    private val TAG = SignUpFragment::class.java.simpleName

    lateinit var binding: FragmentSignUpBinding
    lateinit var loginViewModel: LoginViewModel

    companion object {
        fun newInstance() = SignUpFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        loginViewModel = viewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.let {
            it.viewModel = loginViewModel
            it.setLifecycleOwner(this)
        }

        binding.root.btn_signup.setOnClickListener(::handleSignUpClick)
        return binding.root
    }

    fun handleSignUpClick(view: View?){
        binding.viewModel!!.handleSignUpClick()
                    .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { this.showProgress () }
                .doAfterTerminate { this.hideProgress() }
                .subscribe(object: SingleObserver<User> {
                    override fun onSubscribe(d: Disposable) {
                        d.dispose()
                    }
                    override fun onSuccess(user: User) {
                        Log.i(TAG, "handleSignUpClick: onSuccess()")
                    }
                    override fun onError(e: Throwable) {
                        this@SignUpFragment.context!!.showAlert(e.message.toString())
                    }
                })
    }
}
