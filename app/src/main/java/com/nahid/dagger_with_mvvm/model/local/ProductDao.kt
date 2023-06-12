package com.nahid.dagger_with_mvvm.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nahid.dagger_with_mvvm.model.data.Products
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(products: List<Products>)

    @Query("SELECT * FROM Products")
    fun getProducts(): Flow<List<Products>>
}