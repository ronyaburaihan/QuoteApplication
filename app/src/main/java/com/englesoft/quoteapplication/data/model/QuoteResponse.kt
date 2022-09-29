package com.englesoft.quoteapplication.data.model

data class QuoteResponse(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val quoteItems: List<QuoteItem>,
    val totalCount: Int,
    val totalPages: Int
)