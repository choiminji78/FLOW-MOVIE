package com.example.flow_movie.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.flow_movie.data.repository.MovieRepositoryImpl
import com.example.flow_movie.data.source.db.model.SearchWord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchHistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepositoryImpl = MovieRepositoryImpl.get(getApplication())

    val searchHistory = MutableLiveData<List<SearchWord>>()

    fun loadSearchHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            searchHistory.postValue(repository.getSearchWords())
        }
    }
}