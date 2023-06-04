package com.nahid.dagger_with_mvvm.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nahid.dagger_with_mvvm.model.data.Products

@Database(entities = [Products::class], version = 1)
abstract class ProductDB : RoomDatabase() {

    abstract fun getProductDao(): ProductDao
}