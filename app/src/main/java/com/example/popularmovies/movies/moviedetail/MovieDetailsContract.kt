package com.example.popularmovies.movies.moviedetail

import com.example.popularmovies.base.IBasePresenter
import com.example.popularmovies.base.IBaseView
import com.example.popularmovies.model.MovieDetails
import com.example.popularmovies.model.MovieDetails1

interface MovieDetailsContract {

    interface View: IBaseView {
        fun updateUI(details: MovieDetails1)
    }

    interface Presenter: IBasePresenter<View> {
        fun fetchMovieDetails(id: Long)
        fun onRetryClicked(id: Long)
    }
}