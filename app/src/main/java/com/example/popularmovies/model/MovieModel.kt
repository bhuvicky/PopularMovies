package com.example.popularmovies.model

import com.google.gson.annotations.SerializedName

data class Movie(val page: Int?, val totalResults: Long?, val totalPages: Long?, val details: MutableList<MovieDetails>?)

data class MovieDetails(val voteCount: Int?, val id: Long?, val title: String?, val popularity: Double?, val overview: String?,
                        @SerializedName("vote_average") val voteAverage: Float?,
                        @SerializedName("original_language") val originalLanguage: String?,
                        @SerializedName("poster_path") val posterPath: String?,
                        @SerializedName("backdrop_path") val backdropPath: String?,
                        @SerializedName("genre_ids") val genreIds: List<Int>?,
                        @SerializedName("release_date") val releaseDate: String?)

data class MovieDetails1(val voteCount: Int?, val id: Long?, val title: String?, val popularity: Double?, val overview: String?,
                        @SerializedName("vote_average") val voteAverage: Float?,
                        @SerializedName("original_language") val originalLanguage: String?,
                        @SerializedName("poster_path") val posterPath: String?,
                        @SerializedName("backdrop_path") val backdropPath: String?,
                        @SerializedName("release_date") val releaseDate: String?,

                        @SerializedName("runtime") val runTime: Int?,
                        val genres: List<Genre>?, val budget: Double?, val revenue: Double?)

data class Genre(val id: Int?, val name: String?)