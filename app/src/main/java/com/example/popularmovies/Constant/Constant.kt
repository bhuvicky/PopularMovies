package com.example.popularmovies.Constant

class Constant {

    object NetworkUrl {
        val BASE_URL = "https://api.themoviedb.org/3/"
        val MOVIE_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

        val GET_MOVIE_LIST = "discover/movie?api_key=%s&sort_by=popularity.desc"
        val GET_MOVIE_DETAILS = "movie/335983?api_key=%s"

    }
}