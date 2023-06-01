package com.nahid.dagger_with_mvvm.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nahid.dagger_with_mvvm.repository.ProductRepository
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(private val productRepository: ProductRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }
}