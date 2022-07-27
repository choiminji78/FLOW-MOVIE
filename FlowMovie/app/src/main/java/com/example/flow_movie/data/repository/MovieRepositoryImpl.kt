package com.example.flow_movie.data.repository

import android.content.Context
import com.example.flow_movie.data.source.db.AppDBSourceImpl
import com.example.flow_movie.data.source.db.model.SearchWord
import com.example.flow_movie.data.source.remote.NaverApiSourceImpl
import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import retrofit2.Response

class MovieRepositoryImpl private constructor(private val context: Context) : MovieRepository {
    companion object {
        private var INSTANCE: MovieRepositoryImpl? = null

        fun get(context: Context): MovieRepositoryImpl {
            if (INSTANCE == null) {
                INSTANCE = MovieRepositoryImpl(context)
            }
            return INSTANCE!!
        }
    }

    private val naverApiSourceImpl by lazy { NaverApiSourceImpl.get() }
    private val appDBSourceImpl by lazy { AppDBSourceImpl.get(context) }

    override suspend fun getSearchMovie(query: String, display: Int?): Response<ResponseMovieList> {
        return naverApiSourceImpl.getSearchMovie(query, display)
    }

    override suspend fun getSearchWords(): List<SearchWord> {
        return appDBSourceImpl.getSearchWords()
    }

    override suspend fun saveSearchWord(searchWord: SearchWord) {
        return appDBSourceImpl.saveSearchWord(searchWord)
    }
}