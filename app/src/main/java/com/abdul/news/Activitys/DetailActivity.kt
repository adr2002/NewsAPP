package com.abdul.news.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.abdul.news.R
import com.abdul.news.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val url = intent.getStringExtra("url")

        if (url != null){

            binding.webView.settings.javaScriptEnabled = true

            binding.webView.webViewClient = object :  WebViewClient(){

                override fun onPageFinished(view: WebView?, url: String?) {
                    binding.progressBar2.visibility = View.GONE
                    binding.webView.visibility = View.VISIBLE
                }
            }
            binding.webView.loadUrl(url)
        }
    }
}