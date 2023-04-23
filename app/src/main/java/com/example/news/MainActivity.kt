package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        val  items=fetchData()
        val adapter= Adapter(items,this)
        binding.recyclerview.adapter=adapter
    }

    private fun fetchData():ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 0 until 100){
            list.add("item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"clicked item is $item", Toast.LENGTH_SHORT).show()
        super.onItemClicked(item)

    }

}