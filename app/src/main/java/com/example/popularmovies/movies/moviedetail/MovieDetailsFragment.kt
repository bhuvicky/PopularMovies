package com.example.popularmovies.movies.moviedetail


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularmovies.GlideApp
import com.example.popularmovies.R
import com.example.popularmovies.base.BaseFragment
import com.example.popularmovies.model.MovieDetails
import com.example.popularmovies.model.MovieDetails1
import com.example.popularmovies.movies.movielist.MovieListFragment

import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment: BaseFragment(), MovieDetailsContract.View {

    private var details: MovieDetails? = null
    private var presenter: MovieDetailsPresenter? = null

    companion object {
        fun newInstance(details: MovieDetails) = MovieDetailsFragment().apply {
            this.details = details
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(details?.title ?: "")

        presenter = MovieDetailsPresenter(this)
        presenter?.fetchMovieDetails(details?.id ?: -1)
    }

    override fun updateUI(details: MovieDetails1) {
        GlideApp.with(viewContext())
                .load("")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_search)
                .into(backdropImage)

        movieOverview.text = details.overview
        movieRunTime.text = "${details.runTime} minutes"
        movieReleaseDate.text = details.releaseDate
        movieGenres.text = details.genres?.map { it.name }?.joinToString { "," }
        movieLang.text = details.originalLanguage

    }

    override fun isViewPresent(): Boolean {
        return this.isAdded
    }

    override fun setProgressBar(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(throwable: Throwable) {
        errorView.visibility = View.VISIBLE
        errorView.title = "Error"
        errorView.subtitle = throwable.message ?: ""
        errorView.setRetryListener {
            presenter?.onRetryClicked(details?.id ?: -1)
        }
    }

    override fun hideError() {
        errorView.visibility = View.GONE
    }

    override fun viewContext(): Context {
        return context!!
    }

}