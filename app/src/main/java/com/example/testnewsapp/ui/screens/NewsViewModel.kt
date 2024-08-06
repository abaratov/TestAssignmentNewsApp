package com.example.testnewsapp.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.model.Article
import com.example.testnewsapp.network.NewsApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsApiService: NewsApiService
) : ViewModel() {

    val newsState = mutableStateOf<List<Article>>(emptyList())

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                val response = newsApiService.getTopHeadlines("us", "YOUR_API_KEY")
                if (response.isSuccessful) {
                    newsState.value = response.body()?.articles ?: emptyList()
                }
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}