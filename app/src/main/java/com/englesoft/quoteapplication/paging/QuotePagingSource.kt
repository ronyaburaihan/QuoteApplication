package com.englesoft.quoteapplication.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.englesoft.quoteapplication.data.model.QuoteItem
import com.englesoft.quoteapplication.network.QuoteAPI

class QuotePagingSource(private val quoteAPI: QuoteAPI) : PagingSource<Int, QuoteItem>() {

    override fun getRefreshKey(state: PagingState<Int, QuoteItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, QuoteItem> {
        return try {
            val pagePosition = params.key ?: 1
            val response = quoteAPI.getQuoteList(pagePosition)
            LoadResult.Page(
                data = response.quoteItems,
                prevKey = if (pagePosition == 1) null else pagePosition - 1,
                nextKey = if (pagePosition == response.totalPages) null else pagePosition + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}