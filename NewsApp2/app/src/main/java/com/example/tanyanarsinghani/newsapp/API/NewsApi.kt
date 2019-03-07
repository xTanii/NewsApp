package com.example.tanyanarsinghani.newsapp.API

import android.widget.SearchView
import com.example.tanyanarsinghani.newsapp.data.Model.NewsArticles
import retrofit2.http.GET
import retrofit2.http.QueryMap
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsApi {

    @GET("top-headlines?country=in&apiKey=2c76206f105a485ba35cb0af49de7805")
   fun getAllHighlights():retrofit2.Call<NewsArticles>
    @GET("top-headlines")
    fun getSearchNews(@Query("country") country:String, @Query("category") category:String,@Query("apikey") apikey:String):retrofit2.Call<NewsArticles>
}
