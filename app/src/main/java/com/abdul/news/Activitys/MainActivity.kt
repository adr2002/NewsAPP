package com.abdul.news

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.news.Adapter.NewsAdapter
import com.abdul.news.Adapter.NewsApi.newsInstans
import com.abdul.news.Models.News
import com.abdul.news.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NewsAdapter
   var page = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = androidx.databinding.DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.prorassBar.visibility = View.VISIBLE

           getNews()

    }

    private fun getNews() {
        val news = newsInstans.news_ins.getHeadlines("in",page)
        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()

                if (news != null){

                    binding.prorassBar.visibility = View.INVISIBLE

                    Log.d("Tag",news.toString())

                    adapter = NewsAdapter(this@MainActivity,news.articles)
                    binding.recycaler.adapter = adapter
                    binding.recycaler.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Tag","Error in feaching news")
            }
        })
    }

  }