package com.example.flow_movie.data.source.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.flow_movie.data.source.db.converter.AppTypeConverters
import com.example.flow_movie.data.source.db.dao.SearchWordDao
import com.example.flow_movie.data.source.db.model.SearchWord

@Database(entities = [SearchWord::class], version = 1)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchWordDao(): SearchWordDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                //synchronized : 중복 방지
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}