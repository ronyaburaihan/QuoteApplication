package com.englesoft.quoteapplication.network

import com.englesoft.quoteapplication.data.model.QuoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("quotes")
    suspend fun getQuoteList(@Query("page") page: Int): QuoteResponse
}