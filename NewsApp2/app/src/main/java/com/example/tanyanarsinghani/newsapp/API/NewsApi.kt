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
    fun getSportsNews(@Query("country") country:String, @Query("category") category:String,@Query("apikey") apikey:String):retrofit2.Call<NewsArticles>
    @GET("top-headlines?country=in&category=entertainment&apiKey=2c76206f105a485ba35cb0af49de7805")
    fun getEntertainmentNews():retrofit2.Call<NewsArticles>
    @GET("top-headlines?country=in&category=business&apiKey=2c76206f105a485ba35cb0af49de7805")
    fun getBussinessNews():retrofit2.Call<NewsArticles>
    @GET("top-headlines?country=in&category=health&apiKey=2c76206f105a485ba35cb0af49de7805")
    fun getHealthNews():retrofit2.Call<NewsArticles>
    @GET("top-headlines?country=in&category=science&apiKey=2c76206f105a485ba35cb0af49de7805")
    fun getScienceNews():retrofit2.Call<NewsArticles>
    @GET("top-headlines?country=in&category=technology&apiKey=2c76206f105a485ba35cb0af49de7805")
    fun getTechnologyNews():retrofit2.Call<NewsArticles>
}
