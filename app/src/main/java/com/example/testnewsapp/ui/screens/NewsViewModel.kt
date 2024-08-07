package com.example.testnewsapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.model.Article
import com.example.testnewsapp.network.NewsApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsApiService: NewsApiService
) : ViewModel() {

    private val _newsState = MutableStateFlow<NewsListState>(NewsListState.InitialState)
    val newsState: StateFlow<NewsListState> = _newsState.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _newsState.value = NewsListState.Loading
            delay(4000)
            try {
                val response =
                    newsApiService.getEverything(
                        "android",
                        languages = "ru",
                        apiKey =  "5bb46af4eb9f43b7825d918a48f4e92b"
                    )
                if (response.isSuccessful) {
                    response.body()?.articles?.let {
                        _newsState.value = NewsListState.NewsList(it)
                    }
                }
            } catch (e: Exception) {
                _newsState.value = NewsListState.ErrorState(e.message ?: "An error occurred")
            }
        }
    }
}

sealed class NewsListState {
    data object InitialState : NewsListState()

    data object Loading : NewsListState()
    data class ErrorState(val error: String) : NewsListState()
    data class NewsList(val newsList: List<Article>) : NewsListState()
}