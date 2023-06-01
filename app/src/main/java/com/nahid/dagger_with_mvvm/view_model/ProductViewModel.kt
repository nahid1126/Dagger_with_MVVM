package com.nahid.dagger_with_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahid.dagger_with_mvvm.model.data.Products
import com.nahid.dagger_with_mvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val productLiveData: LiveData<List<Products>>
        get() = productRepository.productList

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}