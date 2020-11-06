package com.example.catsanddogs.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.catsanddogs.R
import com.example.catsanddogs.UserStorage
import com.example.catsanddogs.dashboard.DashboardFragment
import com.example.catsanddogs.home.HomeActivity
import com.example.catsanddogs.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var userStorage: UserStorage

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userStorage = UserStorage(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupProfileCard()
        setupButton()
    }

    private fun setupProfileCard() {
        val user = userStorage.getUser()
        tvName.text = user?.email?.substringBefore("@")
        tvGender.text = "male"
        tvEmail.text = user?.email
        tvPhone.text = "0888888888"
    }

    private fun setupButton() {
        tvLogout.setOnClickListener {
            (context as HomeActivity).startActivity(
                LoginActivity.intent(context)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            userStorage.delUser()
        }
    }

}