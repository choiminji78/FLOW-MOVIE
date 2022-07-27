package com.example.flow_movie.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.flow_movie.R
import com.example.flow_movie.data.source.remote.model.Movie
import com.example.flow_movie.databinding.ActivityMainBinding
import com.example.flow_movie.ui.callback.IClickListener
import com.example.flow_movie.ui.view.adapter.MainAdapter
import com.example.flow_movie.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), IClickListener<Movie> {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this@MainActivity,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(MainViewModel::class.java)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.activity = this@MainActivity

        val dataObserver: Observer<List<Movie>> =
            Observer { movieList ->
                var newAdapter = MainAdapter(movieList, this)
                binding.rvMain.adapter = newAdapter
            }
        viewModel.movieList.observe(this, dataObserver)
    }

    fun onClickSearchHistory() {
        startActivity(SearchHistoryActivity.createIntent(this@MainActivity))
    }

    override fun onClick(item: Movie) {
        startActivity(WebActivity.createIntent(this@MainActivity, item.link))
    }
}