package com.example.recyclerviewreferenceid2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(),PlayerRecyclerAdapter2.onItemClickListener2 {

    private lateinit var playerAdapter2: PlayerRecyclerAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initRecyclerView2()
        addDataSource2()
    }

    private fun addDataSource2(){
        val data2 = DataSource.createDataSet2()
        playerAdapter2.submitList2(data2)
    }
    private fun initRecyclerView2(){
        recycler_view2.apply {
            layoutManager = GridLayoutManager(this@SecondActivity,2)
            playerAdapter2 = PlayerRecyclerAdapter2()
            adapter = playerAdapter2
        }
        playerAdapter2.setOnItemClickListener2(this)
    }

    override fun onItemClick2(position: Int) {
        val intent = Intent(this,ThirdActivity::class.java)
        startActivity(intent)
    }
}