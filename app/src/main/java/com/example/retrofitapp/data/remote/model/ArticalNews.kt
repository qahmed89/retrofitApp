package com.example.navapp.data.model


import androidx.annotation.Keep

@Keep
data class ArticalNews(
    val articles: List<Article?>?,
    val status: String?,
    val totalResults: Int?
)