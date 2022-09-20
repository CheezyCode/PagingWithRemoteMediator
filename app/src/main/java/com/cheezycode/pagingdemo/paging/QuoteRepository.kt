package com.cheezycode.pagingdemo.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.cheezycode.pagingdemo.QuoteDatabase
import com.cheezycode.pagingdemo.QuotesAPI
import javax.inject.Inject

@ExperimentalPagingApi
class QuoteRepository @Inject constructor(
    private val quotesAPI: QuotesAPI,
    private val quoteDatabase: QuoteDatabase
) {

    fun getQuotes() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100
        ),
        remoteMediator = QuoteRemoteMediator(quotesAPI, quoteDatabase),
        pagingSourceFactory = { quoteDatabase.quoteDao().getQuotes() }
    ).liveData

}