package com.cheezycode.pagingdemo.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cheezycode.pagingdemo.QuotesAPI
import com.cheezycode.pagingdemo.models.Result
import java.lang.Exception

const val STARTING_PAGE_INDEX = 1

class QuotePagingSource(private val quotesAPI: QuotesAPI) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = quotesAPI.getQuotes(position)

            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}