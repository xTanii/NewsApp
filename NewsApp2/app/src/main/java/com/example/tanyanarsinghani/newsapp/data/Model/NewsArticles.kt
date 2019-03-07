package com.example.tanyanarsinghani.newsapp.data.Model

import com.example.tanyanarsinghani.newsapp.data.Model.Article

data class NewsArticles(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)