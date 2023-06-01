package com.nahid.dagger_with_mvvm.model.network

import com.nahid.dagger_with_mvvm.model.data.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts(): Response<List<Products>>
}