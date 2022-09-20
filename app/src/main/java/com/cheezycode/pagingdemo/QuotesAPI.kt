package com.cheezycode.pagingdemo

import com.cheezycode.pagingdemo.models.QuoteResult
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : QuoteResult
}