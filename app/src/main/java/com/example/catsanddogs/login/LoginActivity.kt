package com.example.catsanddogs.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.catsanddogs.R
import com.example.catsanddogs.UserStorage
import com.example.catsanddogs.home.HomeActivity
import com.example.catsanddogs.models.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val userStorage = UserStorage(this)
    private val generalTextWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            if (s.hashCode() == etEmail.text.hashCode()) {
                if (!isValidEmail(etEmail.text.toString())) {
                    etEmail.error = "Email tidak sesuai format email"
                } else {
                    etEmail.error = null
                }
                enableOrDisableButton()
            }
            if (s.hashCode() == etPassword.text.hashCode()) {
                if (etPassword.text.toString().length < 6) {
                    etPassword.error = "Password harus lebih banyak dari 6 karakter"
                } else {
                    etPassword.error = null
                }
                enableOrDisableButton()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //nothing
        }
    }

    companion object {
        fun intent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java).apply {
                //if needed
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEditTexts()
        setupButton()
        enableOrDisableButton()
    }

    private fun setupEditTexts() {
        etEmail.addTextChangedListener(generalTextWatcher)
        etPassword.addTextChangedListener(generalTextWatcher)
    }

    private fun setupButton() {
        btnLogin.setOnClickListener {
            userStorage.setUser(
                User(
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
            )
            startActivity(
                HomeActivity.intent(this)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        }
    }

    private fun enableOrDisableButton() {
        btnLogin.isEnabled =
            etEmail.error == null && etPassword.error == null && etEmail.text.toString()
                .isNotBlank() && etPassword.text.toString().isNotBlank()
    }

    private fun isValidEmail(email: String): Boolean {
        if (TextUtils.isEmpty(email)) return false
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}