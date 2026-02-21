package com.deyvieat.store.features.store.data.di

import com.deyvieat.store.core.di.FakeStoreRetrofit
import com.deyvieat.store.features.store.data.datasources.remote.api.StoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StoreNetworkModule {

    @Provides
    @Singleton
    fun provideStoreApi(@FakeStoreRetrofit retrofit: Retrofit): StoreApi {
        return retrofit.create(StoreApi::class.java)
    }
}