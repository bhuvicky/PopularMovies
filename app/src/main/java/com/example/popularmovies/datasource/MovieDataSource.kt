package com.example.popularmovies.datasource

import com.example.popularmovies.Constant.Constant
import com.example.popularmovies.dependency.component.DaggerNetworkComponent
import com.example.popularmovies.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface MovieOperation {

    @GET("discover/movie?")
    fun fetchMovieList(@Query("sort_by") sortBy: String,
                       @Query("api_key") key: String = Constant.Key.TMDB_API_KEY): Call<Movie>

    @GET("movie/{movie_id}?")
    fun fetchMovieDetails(@Path("movie_id") movieId: Long,
                          @Query("api_key") key: String = Constant.Key.TMDB_API_KEY): Call<Movie>
}

class MovieDataSource {

    @Inject
    lateinit var operation: MovieOperation

    init {
        DaggerNetworkComponent.builder().build().inject(this)
    }

    fun fetchMovieList(sortOrder: String): Call<Movie> {
        return operation.fetchMovieList(sortOrder)
    }

    fun fetchMovieDetails(movieId: Long): Call<Movie> {
        return operation.fetchMovieDetails(movieId)
    }
}