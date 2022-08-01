package com.example.recyclerviewreferenceid2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var playerAdapter: PlayerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource(){
        val data = DataSource.createDataSet()
        playerAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            playerAdapter = PlayerRecyclerAdapter()
            adapter = playerAdapter

        }
    }
}