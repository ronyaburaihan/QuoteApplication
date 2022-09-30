package com.englesoft.quoteapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.englesoft.quoteapplication.adapter.LoaderAdapter
import com.englesoft.quoteapplication.adapter.QuoteListAdapter
import com.englesoft.quoteapplication.databinding.ActivityMainBinding
import com.englesoft.quoteapplication.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var quoteListAdapter: QuoteListAdapter
    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init
        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        quoteListAdapter = QuoteListAdapter()

        binding.rvQuotes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = quoteListAdapter.withLoadStateHeaderAndFooter(
                header = LoaderAdapter(),
                footer = LoaderAdapter()
            )
        }

        quoteViewModel.quoteList.observe(this) {
            quoteListAdapter.submitData(lifecycle, it)
        }

    }
}