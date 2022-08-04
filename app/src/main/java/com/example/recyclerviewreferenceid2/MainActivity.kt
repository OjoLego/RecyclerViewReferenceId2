package com.example.recyclerviewreferenceid2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.player_cardview.*

class MainActivity : AppCompatActivity(),PlayerRecyclerAdapter.onItemClickListener {

    private lateinit var recyclerView: RecyclerView

    private lateinit var playerAdapter: PlayerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
//        player_image.setOnClickListener{
//            navigateToSecondActivity()
//        }

    }

    private fun addDataSource(){
        val data = DataSource.createDataSet()
        playerAdapter.submitList(data)
    }
    private fun initRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            playerAdapter = PlayerRecyclerAdapter()
            adapter = playerAdapter
        }
        playerAdapter.setOnItemClickListener(this)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }

//    private fun navigateToSecondActivity(){
//        val intent = Intent(this,SecondActivity::class.java)
//        startActivity(intent)
//    }
}