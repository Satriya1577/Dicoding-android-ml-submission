package com.dicoding.asclepius.ui.articles

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.remote.response.ArticlesItem
import com.dicoding.asclepius.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {
    private val apiService = ApiConfig.getApiService()

    private val _listArticles = MutableLiveData<List<ArticlesItem?>?>()
    val listArticles: LiveData<List<ArticlesItem?>?> = _listArticles

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch {
            try {
                val response = apiService.getArticles()
                if (response.status == "ok") {
                    _listArticles.value = response.articles
                }
            } catch (e: Exception) {
                Log.d("ArticlesResponse", "${e.message}")
            }
        }
    }
}