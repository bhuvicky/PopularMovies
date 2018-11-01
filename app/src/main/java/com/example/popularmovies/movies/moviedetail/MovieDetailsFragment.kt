package com.example.popularmovies.movies.moviedetail


import com.example.popularmovies.base.BaseFragment
import com.example.popularmovies.movies.movielist.MovieListFragment

class MovieDetailsFragment: BaseFragment() {

    private var movieId: Int = 0

    companion object {
        fun newInstance(movieId: Int): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                this.movieId = movieId
            }
        }
    }
}