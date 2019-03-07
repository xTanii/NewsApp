package com.example.tanyanarsinghani.newsapp.UI

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresFeature
import android.support.v7.app.AppCompatActivity
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.tanyanarsinghani.newsapp.R
import com.example.tanyanarsinghani.newsapp.data.Repository.NewsRepository
import kotlinx.android.synthetic.main.activity_newsdetailed.*

class NewsDetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsdetailed)
        val bundle: Bundle? = intent.extras
        val url = bundle?.getInt("url")
        var getarticle = NewsRepository.getArticle()
        if (getarticle.url != null) {
            newswebview.webViewClient = MyWebViewClient(this)
            newswebview.loadUrl(getarticle.url)


        }
        val actionbar=supportActionBar
        actionbar!!.title="NewsApp"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}

class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

   // @RequiresFeature(name = Build.VERSION_CODES.LOLLIPOP.toString())
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }

    override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
        Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
    }
}
