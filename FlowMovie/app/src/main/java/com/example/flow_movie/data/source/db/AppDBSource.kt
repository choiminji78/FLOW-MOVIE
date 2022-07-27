package com.example.flow_movie.data.source.db

import com.example.flow_movie.data.source.db.model.SearchWord

interface AppDBSource {

    suspend fun getSearchWords(): List<SearchWord>

    suspend fun saveSearchWord(searchWord: SearchWord)
}