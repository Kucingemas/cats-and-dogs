package com.example.catsanddogs.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.catsanddogs.R
import com.example.catsanddogs.dashboard.DashboardFragment
import com.example.catsanddogs.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    companion object {
        const val NAV_TAB_DASHBOARD = 1
        const val NAV_TAB_PROFILE = 2

        fun intent(context: Context?): Intent {
            return Intent(context, HomeActivity::class.java).apply {
                //if needed
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupNavigation()
        changeFragment(DashboardFragment.newInstance(), true, NAV_TAB_DASHBOARD.toString())
    }

    override fun onBackPressed() {
        val fragmentDashboard =
            supportFragmentManager.findFragmentByTag(NAV_TAB_DASHBOARD.toString())
        if (supportFragmentManager.fragments.last().tag != NAV_TAB_DASHBOARD.toString()) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragmentDashboard!!)
            transaction.commit()
            changeTab(NAV_TAB_DASHBOARD)
        } else {
            finish()
        }
    }

    private fun setupNavigation() {
        btmNavHome.setOnNavigationItemSelectedListener {
            val fragmentDashboard =
                supportFragmentManager.findFragmentByTag(NAV_TAB_DASHBOARD.toString())
            val fragmentProfile =
                supportFragmentManager.findFragmentByTag(NAV_TAB_PROFILE.toString())
            when (it.itemId) {
                R.id.action_dashboard -> {
                    if (fragmentDashboard == null) {
                        changeFragment(
                            DashboardFragment.newInstance(),
                            true,
                            NAV_TAB_DASHBOARD.toString()
                        )
                    } else {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.container, fragmentDashboard)
                        transaction.commit()
                    }
                }
                R.id.action_profile -> {
                    if (fragmentProfile == null) {
                        changeFragment(
                            ProfileFragment.newInstance(),
                            true,
                            NAV_TAB_PROFILE.toString()
                        )
                    } else {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.container, fragmentProfile)
                        transaction.commit()
                    }
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container, fragment, tag)
        ft.commitAllowingStateLoss()
    }

    private fun changeTab(index: Int) {
        when (index) {
            NAV_TAB_DASHBOARD -> btmNavHome.selectedItemId = R.id.action_dashboard
            NAV_TAB_PROFILE -> btmNavHome.selectedItemId = R.id.action_profile
        }

    }

}