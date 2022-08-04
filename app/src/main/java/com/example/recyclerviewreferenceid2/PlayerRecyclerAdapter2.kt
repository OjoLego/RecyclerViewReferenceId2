package com.example.recyclerviewreferenceid2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_cardview.view.*
import models.Player

class PlayerRecyclerAdapter2: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items2: List<Player> = ArrayList()

    interface onItemClickListener2{
        fun onItemClick2(position: Int)
    }

    private lateinit var nlistener: onItemClickListener2

    fun setOnItemClickListener2(listener: onItemClickListener2){
        nlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayerViewHolder2(
            LayoutInflater.from(parent.context).inflate(R.layout.player_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PlayerViewHolder2 -> {
                holder.bind(items2[position])
            }
        }
        holder.itemView.setOnClickListener {
            nlistener.onItemClick2(position)
        }
    }

    override fun getItemCount(): Int {
        return items2.size
    }

    fun submitList2(player: List<Player>){
        items2 = player
    }

    class PlayerViewHolder2 constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val playerName2 = itemView.player_name
        val playerNumber2 = itemView.player_number
        val playerPosition2 = itemView.player_position
        val playerImage2 = itemView.player_image

        fun bind(player: Player) {
            playerName2.setText(player.name)
            playerNumber2.setText(player.number.toString())
            playerPosition2.setText(player.position)
            playerImage2.setBackgroundResource(player.image)
        }
    }
}