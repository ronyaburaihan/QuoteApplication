package com.englesoft.quoteapplication.util

import androidx.recyclerview.widget.DiffUtil
import com.englesoft.quoteapplication.data.model.QuoteItem

class Comparator : DiffUtil.ItemCallback<QuoteItem>() {

    override fun areItemsTheSame(oldItem: QuoteItem, newItem: QuoteItem): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: QuoteItem, newItem: QuoteItem): Boolean {
        return oldItem == newItem
    }
}