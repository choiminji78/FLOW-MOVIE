package com.example.flow_movie.data.source.remote.api

import com.example.flow_movie.BuildConfig
import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverApi {
    companion object {
        const val Naver_Client_ID = BuildConfig.Naver_Client_ID
        const val Naver_Client_Secret = BuildConfig.Naver_Client_Secret
    }

    @Headers(
        "X-Naver-Client-Id:" + Naver_Client_ID,
        "X-Naver-Client-Secret:" + Naver_Client_Secret
    )
    @GET("v1/search/movie.json")
    suspend fun getSearchMovie(
        @Query("query") query: String,
        @Query("display") display: Int? = null
    ): Response<ResponseMovieList>
}