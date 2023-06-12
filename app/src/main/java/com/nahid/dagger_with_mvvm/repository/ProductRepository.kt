package com.nahid.dagger_with_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nahid.dagger_with_mvvm.model.data.Products
import com.nahid.dagger_with_mvvm.model.local.ProductDB
import com.nahid.dagger_with_mvvm.model.network.ApiInterface
import com.nahid.dagger_with_mvvm.model.network.NetworkResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val productDB: ProductDB
) {

    private val products =
        MutableStateFlow<NetworkResponse<List<Products>>>(NetworkResponse.Empty())
    private val dao = productDB.getProductDao()

    val productListFromDB = dao.getProducts()

    fun getProductList(): SharedFlow<NetworkResponse<List<Products>>> = products.asStateFlow()

    suspend fun getProducts() {
        products.emit(NetworkResponse.Loading())
        try {
            val response = apiInterface.getProducts()
            if (response.isSuccessful && response.body() != null) {
                products.emit(NetworkResponse.Success(response.body()!!))
            } else {
                products.emit(NetworkResponse.Error(response.message()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            products.emit(NetworkResponse.Error("Exception ${e.message.toString()}"))
        }
    }


    suspend fun insertProducts(productList: List<Products>) {
        dao.addProduct(productList)
    }
}