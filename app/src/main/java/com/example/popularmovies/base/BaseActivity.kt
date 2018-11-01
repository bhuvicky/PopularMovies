package com.example.popularmovies.base

import android.support.v7.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    private val fm = supportFragmentManager

    fun replace(containerId: Int, fragment: BaseFragment) {
        val ft = fm.beginTransaction()
        ft.replace(containerId, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        if (fm.backStackEntryCount > 1) {
            fm.popBackStack()
        } else {
            finish()
        }
    }
}