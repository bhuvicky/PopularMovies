package com.example.popularmovies.datasource

import com.example.popularmovies.BuildConfig
import com.example.popularmovies.Constant.Constant
import com.example.popularmovies.dependency.component.DaggerNetworkComponent
import com.example.popularmovies.model.Movie
import com.example.popularmovies.model.MovieDetails
import com.example.popularmovies.model.MovieDetails1
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface MovieOperation {

    @GET("discover/movie?")
    fun fetchMovieList(@Query("api_key") key: String,
                       @Query("sort_by") sortBy: String): Call<Movie>

    @GET("movie/{movie_id}?")
    fun fetchMovieDetails(@Path("movie_id") movieId: Long,
                          @Query("api_key") key: String = BuildConfig.TMDB_API_KEY): Call<MovieDetails1>
}

class MovieDataSource {

    @Inject
    lateinit var operation: MovieOperation

    init {
        DaggerNetworkComponent.builder().build().inject(this)
    }

    fun fetchMovies(sortOrder: String) = operation.fetchMovieList(BuildConfig.TMDB_API_KEY, sortOrder)

    fun fetchMovieDetails(movieId: Long) = operation.fetchMovieDetails(movieId)
}

//class CardConverter @Inject constructor(
//        private val dob: Long
//)