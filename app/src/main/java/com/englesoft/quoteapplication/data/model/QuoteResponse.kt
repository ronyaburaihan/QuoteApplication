package com.englesoft.quoteapplication.data.model

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    @SerializedName("results")
    val quoteItems: List<QuoteItem>,
    val totalCount: Int,
    val totalPages: Int
)