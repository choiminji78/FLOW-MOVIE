package com.example.flow_movie.ui.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.flow_movie.R
import com.example.flow_movie.data.source.db.model.SearchWord
import com.example.flow_movie.databinding.ActivitySearchHistoryBinding
import com.example.flow_movie.ui.view.adapter.MainAdapter
import com.example.flow_movie.ui.view.adapter.SearchHistoryAdapter
import com.example.flow_movie.ui.viewmodel.SearchHistoryViewModel

class SearchHistoryActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SearchHistoryActivity::class.java)
        }
    }

    private lateinit var viewModel: SearchHistoryViewModel
    private lateinit var binding: ActivitySearchHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this@SearchHistoryActivity,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(SearchHistoryViewModel::class.java)

        binding = DataBindingUtil.setContentView(this@SearchHistoryActivity, R.layout.activity_search_history)
        binding.lifecycleOwner = this

        viewModel.loadSearchHistory()
        val dataObserver: Observer<List<SearchWord>> =
            Observer { words ->
                var newAdapter = SearchHistoryAdapter(words)
                binding.rvSearchHistory.adapter = newAdapter
            }
        viewModel.searchHistory.observe(this, dataObserver)
    }
}