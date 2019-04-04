package com.andalus.agora.UserInterface.Fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.andalus.agora.CallBacks.OnViewClickedListener
import com.andalus.agora.R

private const val LOGIN_FRAGMENT_TAG = "login-fragment-tag"
private const val SIGN_UP_FRAGMENT_TAG = "sign-up-fragment-tag"

class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val signUpFragment = SignUpFragment.newInstance()
        val loginFragment = LoginFragment.newInstance()

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction().add(R.id.signContainer, signUpFragment,
            SIGN_UP_FRAGMENT_TAG
        ).commit()

        signUpFragment.onViewClickedListener = OnViewClickedListener {
            if (it.id == R.id.tvSignInSignUp) {
                fragmentManager.beginTransaction().replace(R.id.signContainer, loginFragment,
                    LOGIN_FRAGMENT_TAG
                )
                    .commit()
            }
        }

        loginFragment.onViewClickedListener = OnViewClickedListener {
            if (it.id == R.id.tvSignUpSignIn) {
                fragmentManager.beginTransaction().replace(R.id.signContainer, signUpFragment,
                    LOGIN_FRAGMENT_TAG
                )
                    .commit()
            }
        }

    }
}
