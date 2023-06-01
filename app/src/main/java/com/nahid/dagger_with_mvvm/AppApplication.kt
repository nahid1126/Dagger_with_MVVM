package com.nahid.dagger_with_mvvm

import android.app.Application
import com.nahid.dagger_with_mvvm.model.component.ApplicationComponent
import com.nahid.dagger_with_mvvm.model.component.DaggerApplicationComponent

class AppApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}