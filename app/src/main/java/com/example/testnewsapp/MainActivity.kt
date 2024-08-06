package com.example.testnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.testnewsapp.ui.screens.NewsListScreen
import com.example.testnewsapp.ui.theme.TestNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestNewsAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NewsListScreen()
                }
            }
        }
    }
}