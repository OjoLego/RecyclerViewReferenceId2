package com.example.recyclerviewreferenceid2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewreferenceid2.databinding.PlayerCardviewBinding
//import kotlinx.android.synthetic.main.player_cardview.view.*
import models.Player

class PlayerRecyclerAdapter3: RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var items3: List<Player> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayerViewHolder3(
            PlayerCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PlayerViewHolder3 -> {
                holder.bind(items3[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items3.size
    }

    fun submitList3(player: List<Player>){
        items3 = player
    }

    class PlayerViewHolder3 constructor(
        val binding: PlayerCardviewBinding
    ): RecyclerView.ViewHolder(binding.root){

        val playerName3 = binding.playerName
        val playerNumber3 = binding.playerNumber
        val playerPosition3 = binding.playerPosition
        val playerImage3 = binding.playerImage

        fun bind(player: Player) {
            playerName3.setText(player.name)
            playerNumber3.setText(player.number.toString())
            playerPosition3.setText(player.position)
            playerImage3.setBackgroundResource(player.image)
        }
    }
}