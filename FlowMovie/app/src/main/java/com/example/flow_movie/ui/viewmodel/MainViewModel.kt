package com.example.flow_movie.ui.viewmodel

import android.app.Application
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.flow_movie.data.repository.MovieRepositoryImpl
import com.example.flow_movie.data.source.db.model.SearchWord
import com.example.flow_movie.data.source.remote.model.Movie
import com.example.flow_movie.data.source.remote.model.ResponseMovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepositoryImpl = MovieRepositoryImpl.get(getApplication())

    val movieList = MutableLiveData<List<Movie>>()
    var searchWord: String? = null

    fun onSearch(word: String) {
        if (!word.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.Main) {
                var items: List<Movie>? = withContext(Dispatchers.IO) {
                    repository.saveSearchWord(SearchWord(word))
                    val response = repository.getSearchMovie(word)
                    (response?.body() as ResponseMovieList)?.items
                }
                movieList.postValue(items ?: listOf())
            }
        }
    }

    fun onEditTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                searchWord = s.toString()
            }
        }
    }
}