package com.example.flow_movie.data.source.db

import android.content.Context
import com.example.flow_movie.data.source.db.model.SearchWord

class AppDBSourceImpl private constructor(private val context: Context) : AppDBSource {

    companion object {
        private var INSTANCE: AppDBSourceImpl? = null

        fun get(context: Context): AppDBSourceImpl {
            if (INSTANCE == null) {
                INSTANCE = AppDBSourceImpl(context)
            }
            return INSTANCE!!
        }
    }

    private val searchWordDao by lazy {
        AppDatabase.get(context)!!.searchWordDao()
    }

    override suspend fun getSearchWords(): List<SearchWord> {
        return searchWordDao.getAllWord()
    }

    override suspend fun saveSearchWord(searchWord: SearchWord) {
        return searchWordDao.insert(searchWord)
    }
}