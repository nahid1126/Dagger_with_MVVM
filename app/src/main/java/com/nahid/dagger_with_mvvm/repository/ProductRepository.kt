package com.nahid.dagger_with_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nahid.dagger_with_mvvm.model.data.Products
import com.nahid.dagger_with_mvvm.model.local.ProductDB
import com.nahid.dagger_with_mvvm.model.network.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val productDB: ProductDB
) {

    private val _products = MutableLiveData<List<Products>>()
    private val dao = productDB.getProductDao()
    val productList: LiveData<List<Products>>
        get() = _products

    val productListFromDB = dao.getProducts()
    suspend fun getProducts() {
        val response = apiInterface.getProducts()
        if (response.isSuccessful && response.body() != null) {
            _products.postValue(response.body())
        } else {
            _products.postValue(ArrayList())
        }
    }


    suspend fun insertProducts(productList: List<Products>) {
        dao.addProduct(productList)
    }
}