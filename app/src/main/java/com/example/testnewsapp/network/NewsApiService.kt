package com.example.testnewsapp.network

import com.example.testnewsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("languages") languages: String = "en",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String,
    ): Response<NewsResponse>
}
