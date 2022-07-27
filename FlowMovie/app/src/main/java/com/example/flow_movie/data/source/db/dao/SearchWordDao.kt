package com.example.flow_movie.data.source.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.flow_movie.data.source.db.model.SearchWord

@Dao
interface SearchWordDao {
    @Query("SELECT * FROM search_word ORDER BY date DESC LIMIT 10")
    suspend fun getAllWord(): List<SearchWord>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(searchWord: SearchWord)
}