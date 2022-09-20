package com.cheezycode.pagingdemo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheezycode.pagingdemo.db.QuoteDao
import com.cheezycode.pagingdemo.db.RemoteKeysDao
import com.cheezycode.pagingdemo.models.QuoteRemoteKeys
import com.cheezycode.pagingdemo.models.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao
    abstract fun remoteKeysDao() : RemoteKeysDao
}