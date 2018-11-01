package com.example.popularmovies.base

import com.example.popularmovies.movies.movielist.MovieListContract

interface IBasePresenter<T> {

    fun onViewActive(view: T)
    fun onViewInactive()
}