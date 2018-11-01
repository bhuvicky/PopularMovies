package com.example.popularmovies.movies.movielist

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.*
import com.example.popularmovies.R
import com.example.popularmovies.base.BaseFragment
import com.example.popularmovies.model.Movie
import com.example.popularmovies.movies.moviedetail.MovieDetailsFragment

import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment: BaseFragment(), MovieListContract.View {

    private lateinit var adapter: MovieAdapter
    private var movie: Movie? = null
    private var presenter: MovieListPresenter? = null

    companion object {
        fun newInstance() = MovieListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MovieListPresenter(this)
        presenter?.onViewActive(this)
        presenter?.onScreenAppeared(movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_movie_list, menu)
    }

    override fun initRecyclerView(adapter: MovieAdapter, manager: RecyclerView.LayoutManager) {
        this.adapter = adapter
        recyclerViewMovieList.layoutManager = manager
        recyclerViewMovieList.adapter = adapter
    }

    override fun showMovieList(data: Movie?) {
        this.movie = data
        adapter.setData(data)
    }

    override fun showMovieDetailsScreen(movieId: Int) {
        replace(R.id.fragment_host, MovieDetailsFragment.newInstance(movieId))
    }


    override fun isViewPresent(): Boolean {
        return isAdded
    }

    override fun setProgressBar(show: Boolean) {
        when (show) {
            true -> {
                progressBar.visibility = View.VISIBLE
            }
            false -> {
                progressBar.visibility = View.GONE
            }
        }
    }

    override fun showError(throwable: Throwable) {
        errorView.visibility = View.VISIBLE
        errorView.setTitle("Error")
        errorView.setSubtitle(throwable.message)
        errorView.setRetryListener {
            errorView.visibility = View.GONE
            presenter?.onRetryClicked()
        }
    }

    override fun hideError() {
        errorView.visibility = View.GONE
    }

    override fun viewContext(): Context {
        return this@MovieListFragment.context!!
    }
}