package com.example.popularmovies.Constant

class Constant {

    object Key {
        val TMDB_API_KEY = "b54f8fadaabb9c991f219fd302c68da9"
    }

    object NetworkUrl {
        val BASE_URL = "https://api.themoviedb.org/3/"
        val MOVIE_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

        val GET_MOVIE_LIST = "discover/movie?api_key=%s&sort_by=popularity.desc"
        val GET_MOVIE_DETAILS = "movie/335983?api_key=%s"

    }
}