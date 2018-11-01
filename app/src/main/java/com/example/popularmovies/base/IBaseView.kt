package com.example.popularmovies.base

import android.content.Context
import android.support.v4.app.FragmentActivity

interface IBaseView {

    fun isViewPresent() : Boolean

    fun setProgressBar(show: Boolean)

    fun showError(throwable: Throwable)

    fun hideError()

    fun viewContext() : Context
}