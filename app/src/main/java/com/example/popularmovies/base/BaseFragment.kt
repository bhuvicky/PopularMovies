package com.example.popularmovies.base

import android.support.v4.app.Fragment

open class BaseFragment: Fragment() {

    protected fun replace(containerId: Int, fragment: BaseFragment) {
        (activity as BaseActivity).replace(containerId, fragment)
    }

}