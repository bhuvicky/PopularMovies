package com.example.popularmovies.movies.moviedetail

import com.example.popularmovies.datasource.MovieDataSource
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieDetails
import com.example.popularmovies.model.MovieDetails1
import com.example.popularmovies.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsPresenter(val view: MovieDetailsContract.View): MovieDetailsContract.Presenter {

    override fun onViewActive(view: MovieDetailsContract.View) {

    }

    override fun onViewInactive() {

    }

    override fun fetchMovieDetails(id: Long) {
        view.setProgressBar(true)

        if (!NetworkUtils.isNetworkAvailable(view.viewContext())) {
            showErrorView(Throwable("No network Connection..!!"))
            return
        }

        val dataSource = MovieDataSource()
        val call = dataSource.fetchMovieDetails(id)

        call.enqueue(object: Callback<MovieDetails1> {
            override fun onFailure(call: Call<MovieDetails1>, t: Throwable) {
                showErrorView(t)
            }

            override fun onResponse(call: Call<MovieDetails1>, response: Response<MovieDetails1>) {
                showErrorView()
                if (response.isSuccessful) {
                    view.updateUI(response.body()!!)
                }

            }

        })
    }

    private fun showErrorView(t: Throwable? = null) {
        if (!view.isViewPresent())
            return

        view.setProgressBar(false)
        t.let {
            view.showError(t!!)
        }
    }

    override fun onRetryClicked(id: Long) {
        fetchMovieDetails(id)
    }
}