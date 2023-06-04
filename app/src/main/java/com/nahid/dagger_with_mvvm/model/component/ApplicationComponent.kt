package com.nahid.dagger_with_mvvm.model.component

import android.content.Context
import com.nahid.dagger_with_mvvm.model.module.DatabaseModule
import com.nahid.dagger_with_mvvm.model.module.NetworkModule
import com.nahid.dagger_with_mvvm.view.activities.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}