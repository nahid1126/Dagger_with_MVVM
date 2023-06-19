package com.nahid.dagger_with_mvvm.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahid.dagger_with_mvvm.model.data.Products
import com.nahid.dagger_with_mvvm.repository.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "ProductViewModel"

class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val randomize: Randomize
) : ViewModel() {

    val productsFlow = productRepository.getProductList()

    init {
        viewModelScope.launch {
            withContext(IO) {
                productRepository.getProducts()
            }
        }
    }

    fun insertLocalDB(products: List<Products>) {
        viewModelScope.launch {
            withContext(IO) {
                productRepository.insertProducts(products)
            }
        }
    }

    val productList = productRepository.productListFromDB.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), null
    )
}

class Randomize @Inject constructor() {
    fun doAction() {
        Log.d(TAG, "doAction: ")
    }
}