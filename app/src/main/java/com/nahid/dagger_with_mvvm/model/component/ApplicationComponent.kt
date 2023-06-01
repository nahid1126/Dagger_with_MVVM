package com.nahid.dagger_with_mvvm.model.component

import com.nahid.dagger_with_mvvm.model.module.NetworkModule
import com.nahid.dagger_with_mvvm.view.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}