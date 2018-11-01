package com.example.popularmovies.movies.movielist

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.popularmovies.datasource.MovieDataSource
import com.example.popularmovies.model.Movie
import com.example.popularmovies.utils.NetworkUtils
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class MovieListPresenter(val view: MovieListContract.View): MovieListContract.Presenter {

    override fun onViewActive(view: MovieListContract.View) {
        val adapter = MovieAdapter(view.viewContext())
        adapter.presenter = this

        view.initRecyclerView(adapter, LinearLayoutManager(view.viewContext()))
    }

    override fun onViewInactive() {

    }

    override fun onScreenAppeared(data: Movie?) {
        data?.let {
            view.showMovieList(data)
        } ?: fetchMovieList()
    }

    override fun onMovieItemClicked(movieId: Int) {
        view.showMovieDetailsScreen(movieId)
    }

    private fun fetchMovieList() {
        view.setProgressBar(true)

        if(NetworkUtils.isNetworkAvailable(view.viewContext())) {
            view.hideError()
        } else {
            view.setProgressBar(false)
            view.showError(Throwable("NO Internet Connection..!!"))
            return
        }

        val dataSource = MovieDataSource()

        val call = dataSource.fetchMovies("popularity.desc")
        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                view.showError(t!!)
            }
            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                if (response?.isSuccessful()!!) {
                    view.showMovieList(response?.body())
                    updateErrorStatus()
                } else {
                    Log.d("log", response?.code().toString())
                }
            }

        })
    }

    fun updateErrorStatus() {
        if (view.isViewPresent()) {
            view.setProgressBar(false)

        }
    }

    override fun onRetryClicked() {
        fetchMovieList()
    }
}