package com.example.popularmovies.movies.movielist

import android.support.v7.widget.RecyclerView
import com.example.popularmovies.base.IBasePresenter
import com.example.popularmovies.base.IBaseView
import com.example.popularmovies.model.Movie

interface MovieListContract {

    interface View: IBaseView {
        fun initRecyclerView(adapter: MovieAdapter, manager: RecyclerView.LayoutManager)
        fun showMovieList(data: Movie?)
        fun showMovieDetailsScreen(movieId: Int)
    }

    interface Presenter: IBasePresenter<View> {
        fun onScreenAppeared(data: Movie?)
        fun onRetryClicked()
        fun onMovieItemClicked(movieId: Int)
    }
}