package com.example.catsanddogs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catsanddogs.home.HomeActivity
import com.example.catsanddogs.login.LoginActivity


class MainActivity : AppCompatActivity() {

    private val userStorage = UserStorage(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        goToNextScreen()
    }

    private fun goToNextScreen() {
        if (userStorage.getUser() != null) {
            //home activity
            startActivity(
                HomeActivity.intent(this)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        } else {
            //login activity
            startActivity(
                LoginActivity.intent(this)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        }
    }
}