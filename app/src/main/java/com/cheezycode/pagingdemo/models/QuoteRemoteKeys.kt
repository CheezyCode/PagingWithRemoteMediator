package com.cheezycode.pagingdemo.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteRemoteKeys(

    @PrimaryKey(autoGenerate = false)
    val id: String,

    val prevPage: Int?,
    val nextPage: Int?
)