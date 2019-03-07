package com.example.tanyanarsinghani.newsapp.UI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.widget.Toast
import com.example.tanyanarsinghani.newsapp.API.NewsApi
import com.example.tanyanarsinghani.newsapp.API.NewsApiService
import com.example.tanyanarsinghani.newsapp.R
import com.example.tanyanarsinghani.newsapp.data.Model.Article
import com.example.tanyanarsinghani.newsapp.data.Model.NewsArticles
import com.example.tanyanarsinghani.newsapp.data.Repository.NewsRepository
import retrofit2.Call
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_news_first_pg.*
import kotlinx.android.synthetic.main.viewholderlayout.*
import retrofit2.Callback

class NewsFirstPageActivity: AppCompatActivity(), retrofit2.Callback<NewsArticles>, NewsAdapter.ItemClickListener {

    val data = ArrayList<Article>()
    val displaylist = ArrayList<Article>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_first_pg)
        var newsdata = NewsApiService.create()
        newsdata.getAllHighlights().enqueue(this)
        rcnews.layoutManager = LinearLayoutManager(this)
        rcnews.adapter = NewsAdapter(data, this)





    }


    override fun onFailure(call: Call<NewsArticles>, t: Throwable) {

    }

    override fun onResponse(call: Call<NewsArticles>, response: Response<NewsArticles>) {
        val newsarticles = response?.body()

        if (newsarticles != null) {
            data.clear()
            data.addAll(newsarticles.articles)
            rcnews.adapter?.notifyDataSetChanged()
        }
    }

    override fun onClick(article: Article) {
        NewsRepository.saveCurrentArtcile(article)
        val intent= Intent(this,NewsDetailedActivity::class.java)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        val searchitem=menu.findItem(R.id.newssearch)
        if(searchitem!=null) {
            val searchview = searchitem.actionView as SearchView
            searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (p0!= null) {
                        data.clear()
                        val search=p0.toLowerCase()
                        val country="in"
                        val apikey="2c76206f105a485ba35cb0af49de7805"
                        var newsdata=NewsApiService.create()
                        newsdata.getSearchNews(country,search,apikey).enqueue(this@NewsFirstPageActivity)
                    } else {
                        displaylist.clear()
                        displaylist.addAll(data)
                        rcnews.adapter?.notifyDataSetChanged()

                    }
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return true
                }

            }
            )

        }
        return super.onCreateOptionsMenu(menu)
    }

}
