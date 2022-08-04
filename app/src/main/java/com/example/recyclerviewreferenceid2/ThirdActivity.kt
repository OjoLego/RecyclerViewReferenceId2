package com.example.recyclerviewreferenceid2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewreferenceid2.databinding.ActivityThirdBinding
//import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    private lateinit var playerAdapter3: PlayerRecyclerAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView3()
        addDataSource3()
    }
    private fun addDataSource3(){
        val data3 = DataSource.createDataSet3()
        playerAdapter3.submitList3(data3)
    }

    private fun initRecyclerView3(){
        binding.recyclerView3.apply {
            layoutManager = GridLayoutManager(this@ThirdActivity,2)
            playerAdapter3 = PlayerRecyclerAdapter3()
            adapter = playerAdapter3
        }
    }
}