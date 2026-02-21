package com.deyvieat.store.features.store.data.di

import com.deyvieat.store.features.store.data.repositories.ProductRepositoryImpl
import com.deyvieat.store.features.store.domain.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}