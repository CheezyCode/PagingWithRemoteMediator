package com.cheezycode.pagingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.pagingdemo.paging.QuotePagingAdapter
import com.cheezycode.pagingdemo.paging.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.quoteList)
        val adapter = QuotePagingAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter


        quoteViewModel.list.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}