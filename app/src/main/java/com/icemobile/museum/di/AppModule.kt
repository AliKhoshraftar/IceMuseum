package com.icemobile.museum.di

import com.icemobile.museum.data.remote.retrofit.CollectionRetrofitService
import com.icemobile.museum.data.repository.collection.CollectionRepositoryImpl
import com.icemobile.museum.domain.repository.CollectionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCollectionRepository(api: CollectionRetrofitService): CollectionRepository {
        return CollectionRepositoryImpl(api)
    }
}