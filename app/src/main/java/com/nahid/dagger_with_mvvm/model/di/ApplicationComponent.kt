package com.nahid.dagger_with_mvvm.model.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.nahid.dagger_with_mvvm.view.activities.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun getViewModelMap(): Map<Class<*>, ViewModel>
}