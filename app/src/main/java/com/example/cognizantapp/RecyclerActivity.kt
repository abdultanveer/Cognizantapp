package com.example.cognizantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    lateinit var menuRecyclerView: RecyclerView
    var dishes = arrayOf("pizza","burger","ice cream",
        "pizza","burger","ice cream","pizza","burger","ice cream","pizza","burger","ice cream",
        "pizza","burger","ice cream","pizza","burger","ice cream","pizza","burger","ice cream",
        "pizza","burger","ice cream","pizza","burger","ice cream","pizza","burger","ice cream",
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        menuRecyclerView = findViewById(R.id.menuRecyclerview)
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = DishAdapter(dishes)
        menuRecyclerView.adapter = adapter
    }
}