package com.example.popularmovies.movies.movielist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularmovies.Constant.Constant
import com.example.popularmovies.GlideApp
import com.example.popularmovies.R
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieResult

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie_overview.*


class MovieAdapter(val context:Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    public var presenter: MovieListPresenter? = null
    private var movieList: MutableList<MovieResult>? = null

    public fun setData(movie: Movie?) {
        movieList = movie?.results
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_overview, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList?.get(position)

        holder.movieTitle.text = item?.title
        holder.movieOverview.text = item?.overview
        holder.movieRating.text = "${item?.voteAverage}"
        holder.movieReleaseDate.text = item?.releaseDate
        holder.movieLang.text = item?.originalLanguage

        GlideApp.with(context)
                .load("${Constant.NetworkUrl.MOVIE_IMAGE_BASE_URL}${item?.posterPath}")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_right_arrow)
                .into(holder.posterImage);

        holder.rootView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    class MovieViewHolder(override val containerView: View?): RecyclerView.ViewHolder(containerView!!), LayoutContainer
}