package com.example.popularmovies.base

import android.content.Context
import androidx.core.app.FragmentActivity

interface IBaseView {

    fun isViewPresent() : Boolean

    fun setProgressBar(show: Boolean)

    fun showError(throwable: Throwable)

    fun hideError()

    fun viewContext() : Context
}