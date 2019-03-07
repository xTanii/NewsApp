package com.example.tanyanarsinghani.newsapp.data.Repository

import com.example.tanyanarsinghani.newsapp.data.Model.Article
import com.example.tanyanarsinghani.newsapp.data.Model.NewsArticles
import java.net.URL
import java.util.ArrayList


    object NewsRepository {

        lateinit var currentArticle : Article

        fun saveCurrentArtcile(article: Article) {
            this.currentArticle = article
        }

        fun getArticle(): Article {
            return currentArticle
        }

    }