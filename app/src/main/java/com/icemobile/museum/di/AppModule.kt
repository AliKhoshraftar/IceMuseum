package com.icemobile.museum.di

import com.icemobile.museum.BuildConfig
import com.icemobile.museum.common.Constants
import com.icemobile.museum.data.remote.common.interceptor.AuthenticationInterceptor
import com.icemobile.museum.data.remote.retrofit.CollectionRetrofitService
import com.icemobile.museum.data.repository.collection.CollectionRepositoryImpl
import com.icemobile.museum.domain.repository.CollectionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            // Add pass apiKey for every api request instead of putting on every retrofit methods
            // Also Api key is added to local.properties to be more secure (local.properties normally won't add to git)
            .addInterceptor(AuthenticationInterceptor(BuildConfig.API_KEY))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideCollectionRetrofitService(okHttpClient: OkHttpClient): CollectionRetrofitService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CollectionRetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CollectionRetrofitService): CollectionRepository {
        return CollectionRepositoryImpl(api)
    }
}