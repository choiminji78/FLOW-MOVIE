package com.example.flow_movie.data.repository

import androidx.lifecycle.LiveData
import com.example.flow_movie.data.source.db.model.SearchWord
import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import retrofit2.Response

interface MovieRepository {
    suspend fun getSearchMovie(
        query: String,
        display: Int? = null
    ): Response<ResponseMovieList>

    suspend fun getSearchWords(): List<SearchWord>

    suspend fun saveSearchWord(searchWord: SearchWord)
}