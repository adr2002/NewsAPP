package com.abdul.news.Adapter.NewsApi

import com.abdul.news.Models.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val base_url = "https://newsapi.org/"
const val API_Key = "f53c2554d4524da1ae9f460f7e7926e3"

interface NewsServise {

    @GET("v2/top-headlines?apiKey=$API_Key")
    fun getHeadlines(@Query("country") contry: String, @Query("page") page: Int): Call<News>
}



// Retrofit Instance

object newsInstans {

    val news_ins: NewsServise

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())
                .build()
        news_ins = retrofit.create(NewsServise::class.java)
    }

}