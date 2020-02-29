package com.example.popularmovies.base

import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    protected fun replace(containerId: Int, fragment: BaseFragment) {
        (activity as BaseActivity).replace(containerId, fragment)
    }

    protected fun setTitle(title: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).setTitle(title)
        }
    }
}