package com.example.flow_movie.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flow_movie.R
import com.example.flow_movie.data.source.db.model.SearchWord
import com.example.flow_movie.databinding.ItemWordBinding

class SearchHistoryAdapter(
    private val items: List<SearchWord>
) : RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemWordBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_word, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(word: SearchWord) {
            binding.searchWord = word
        }
    }
}