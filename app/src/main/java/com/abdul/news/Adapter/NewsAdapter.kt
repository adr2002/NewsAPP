package com.abdul.news.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abdul.news.Activitys.DetailActivity
import com.abdul.news.Models.Article
import com.abdul.news.R
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context, val article: List<Article>): RecyclerView.Adapter<NewsAdapter.viewHolder>() {

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        val newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sample_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val article = article[position]

        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,article.title, Toast.LENGTH_LONG).show()

            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("url",article.url)
            context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
     return   article.size
    }
}