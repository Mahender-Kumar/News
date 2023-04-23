package com.example.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val items:ArrayList<String>, private val listener:NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
            val viewHolder=NewsViewHolder(view)
            view.setOnClickListener{
                listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=items[position]
        holder.titleview.text=currentItem
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val  titleview: TextView = itemView.findViewById(R.id.title)


}

interface NewsItemClicked{
    fun onItemClicked(item:String){


    }




}