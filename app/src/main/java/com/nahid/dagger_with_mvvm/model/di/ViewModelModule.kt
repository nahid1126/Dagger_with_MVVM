package com.nahid.dagger_with_mvvm.model.di

import androidx.lifecycle.ViewModel
import com.nahid.dagger_with_mvvm.view_model.AnotherViewModel
import com.nahid.dagger_with_mvvm.view_model.ProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ClassKey(ProductViewModel::class)
    abstract fun productViewModel(productViewModel: ProductViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(AnotherViewModel::class)
    abstract fun anotherViewModel(anotherViewModel: AnotherViewModel):ViewModel
}