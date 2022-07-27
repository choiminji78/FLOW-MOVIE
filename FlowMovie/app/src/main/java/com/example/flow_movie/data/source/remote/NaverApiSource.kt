package com.example.flow_movie.data.source.remote

import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import retrofit2.Response

interface NaverApiSource {
    suspend fun getSearchMovie(
        query: String,
        display: Int? = null
    ): Response<ResponseMovieList>
}