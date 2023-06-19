package com.nahid.dagger_with_mvvm

import android.app.Application
import com.nahid.dagger_with_mvvm.model.di.ApplicationComponent
import com.nahid.dagger_with_mvvm.model.di.DaggerApplicationComponent

class AppApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}