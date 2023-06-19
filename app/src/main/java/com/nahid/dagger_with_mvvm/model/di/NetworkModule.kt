package com.nahid.dagger_with_mvvm.model.di

import com.nahid.dagger_with_mvvm.model.network.ApiInterface
import com.nahid.dagger_with_mvvm.utils.AppConstant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun createApiReference(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)
}