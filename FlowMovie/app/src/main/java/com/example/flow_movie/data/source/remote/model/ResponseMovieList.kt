package com.example.flow_movie.data.source.remote.model

import java.util.*
import kotlin.collections.ArrayList

data class ResponseMovieList(
    val items: List<Movie>
)

data class Movie(
    val title: String,
    val link: String,
    val image: String,
    val subtitle: String,
    val pubDate: String,
    val userRating: Float
)