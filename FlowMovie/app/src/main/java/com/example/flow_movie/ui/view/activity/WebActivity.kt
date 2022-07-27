package com.example.flow_movie.ui.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.flow_movie.R
import com.example.flow_movie.databinding.ActivityWebBinding
import com.example.flow_movie.ui.viewmodel.WebViewModel

class WebActivity : AppCompatActivity() {
    companion object {
        private const val INTENT_EXTRA_KEY_URL = "intent.extra.url"

        fun createIntent(context: Context, url: String): Intent {
            return Intent(context, WebActivity::class.java)
                .putExtra(INTENT_EXTRA_KEY_URL, url)
        }
    }

    private lateinit var viewModel: WebViewModel
    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this@WebActivity, ViewModelProvider.NewInstanceFactory()).get(WebViewModel::class.java).apply {
            url = intent?.getStringExtra(INTENT_EXTRA_KEY_URL)
        }

        binding = DataBindingUtil.setContentView(this@WebActivity, R.layout.activity_web)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}