package com.englesoft.quoteapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.englesoft.quoteapplication.data.model.QuoteItem
import com.englesoft.quoteapplication.databinding.LayoutQuoteItemBinding
import com.englesoft.quoteapplication.util.Comparator

class QuoteListAdapter :
    PagingDataAdapter<QuoteItem, QuoteListAdapter.QuoteViewHolder>(Comparator()) {

    inner class QuoteViewHolder(val binding: LayoutQuoteItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quoteItem = getItem(position)
        quoteItem?.let {
            holder.binding.tvQuote.text = it.content
            holder.binding.tvAuthorName.text = it.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            LayoutQuoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}