package com.example.flow_movie.data.source.remote

import com.example.flow_movie.data.source.remote.api.NaverApi
import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NaverApiSourceImpl private constructor() : NaverApiSource {

    companion object {
        private const val BASE_URL = "https://openapi.naver.com/"

        private val INSTANCE by lazy {
            NaverApiSourceImpl()
        }

        fun get() = INSTANCE
    }

    private val naverApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NaverApi::class.java)
    }

    override suspend fun getSearchMovie(query: String, display: Int?): Response<ResponseMovieList> {
        return naverApi.getSearchMovie(query, display)

    }
}