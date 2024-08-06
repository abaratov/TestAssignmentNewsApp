package com.example.testnewsapp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.testnewsapp.model.Article

@Composable
fun NewsListScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {
    val articles by viewModel.newsState

    LazyColumn {
        items(articles) { article ->
            NewsItem(article)
        }
    }
}

@Composable
fun NewsItem(article: Article) {
    Column {
        Text(article.title, style = MaterialTheme.typography.headlineSmall)
        Text(article.description ?: "", style = MaterialTheme.typography.bodyMedium)

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.url)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.height(200.dp).fillMaxWidth().border(width = 1.dp, color = Color.Black)
        )
    }
}