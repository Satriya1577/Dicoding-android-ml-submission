package com.dicoding.asclepius.data.remote.retrofit


import com.dicoding.asclepius.BuildConfig
import com.dicoding.asclepius.data.remote.response.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getArticles(
        @Query("q") q: String = null ?: "cancer",
        @Query("category") category: String = null ?: "health",
        @Query("language") language: String = null ?: "en",
        @Query("apiKey") apiKey: String = null ?: BuildConfig.API_KEY
    ): ArticleResponse
}