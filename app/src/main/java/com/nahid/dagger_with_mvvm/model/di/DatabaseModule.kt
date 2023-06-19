package com.nahid.dagger_with_mvvm.model.di

import android.content.Context
import androidx.room.Room
import com.nahid.dagger_with_mvvm.model.local.ProductDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getProductDB(context: Context): ProductDB {
        return Room.databaseBuilder(context, ProductDB::class.java, "ProductDB").build()
    }
}