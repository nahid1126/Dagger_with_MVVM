package com.nahid.dagger_with_mvvm.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nahid.dagger_with_mvvm.model.data.Products

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(products: List<Products>)

    @Query("SELECT * FROM Products")
    suspend fun getProducts(): List<Products>
}