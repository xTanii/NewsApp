package com.example.tanyanarsinghani.newsapp.UI

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tanyanarsinghani.newsapp.R
import com.example.tanyanarsinghani.newsapp.data.Model.Article
import kotlinx.android.synthetic.main.viewholderlayout.view.*

class NewsAdapter(val newsData: List<Article>, val itemClickListener : ItemClickListener? = null) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(article: Article) {

            view.setOnClickListener{
                val intent= Intent(context,NewsDetailedActivity::class.java)
                intent.putExtra("Text",view.newstext.text)
                intent.putExtra("Image",view.newsimage.toString())

            }
        }

        var context = view.context
        val newsImage = view.newsimage
        var newstext = view.newstext

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.viewholderlayout, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = newsData.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.newstext.text = newsData[p1].title
        p0.bind(newsData[p1])
        Glide.with(p0.context)
            .load(newsData[p1].urlToImage)
            .into(p0.newsImage)
        p0.itemView.setOnClickListener { itemClickListener?.onClick(newsData[p1]) }

    }

    interface ItemClickListener {
        fun onClick(article: Article)
    }

}