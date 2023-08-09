package com.example.retrofitapp.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.retrofitapp.presentation.screens.home.composable.ListArticles
import com.example.retrofitapp.presentation.screens.home.composable.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.homeState.collectAsState()
    Scaffold(modifier =Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize() ){
            LoadingScreen(isLoading = state.isLoading, modifier = Modifier.align(Alignment.Center))
            ListArticles(list = state.listArticle)
        }
    }
}