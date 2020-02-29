package com.example.popularmovies.movies.movielist

import android.support.v7.widget.RecyclerView
import com.example.popularmovies.base.IBasePresenter
import com.example.popularmovies.base.IBaseView
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieDetails

interface MovieListContract {

    interface View: IBaseView {
        fun initRecyclerView(adapter: MovieAdapter, manager: RecyclerView.LayoutManager)
        fun showMovieList(data: Movie?)
        fun showMovieDetailsScreen(details: MovieDetails)
    }

    interface Presenter: IBasePresenter<View> {
        fun onScreenAppeared(data: Movie?)
        fun onRetryClicked()
        fun onMovieItemClicked(details: MovieDetails)
    }
}