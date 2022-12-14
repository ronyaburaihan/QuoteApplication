package com.englesoft.quoteapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.englesoft.quoteapplication.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(repository: QuoteRepository) : ViewModel() {

    val quoteList = repository.getQuotes().cachedIn(viewModelScope)
}