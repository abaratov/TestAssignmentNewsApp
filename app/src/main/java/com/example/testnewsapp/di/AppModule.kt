package com.example.testnewsapp.di

import com.example.testnewsapp.network.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}