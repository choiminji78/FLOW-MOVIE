package com.example.flow_movie

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("image")
    @JvmStatic
    fun ImageView.loadImage(url: String?) {
        url?.let {
            Glide.with(context)
                .load(it)
                .fitCenter()
                .error(R.drawable.ic_launcher_background)
                .into(this)
        }
    }

    @BindingAdapter("url")
    @JvmStatic
    fun WebView.loadUrl(url: String?) {
        url?.let {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true

            loadUrl(url)
        }
    }
}