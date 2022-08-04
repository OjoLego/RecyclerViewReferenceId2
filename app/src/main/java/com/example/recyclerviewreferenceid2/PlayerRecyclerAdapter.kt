package com.example.recyclerviewreferenceid2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
//import kotlinx.android.synthetic.main.player_cardview.view.*
import models.Player

class PlayerRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items:List<Player> = ArrayList()

//    var onItemClick : ((Player) -> Unit)? = null

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mlistener: onItemClickListener

    fun setOnItemClickListener(listener: onItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.player_cardview,parent,false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PlayerViewHolder -> {
                holder.bind(items[position])
            }
        }
        holder.itemView.setOnClickListener {
            mlistener.onItemClick(position)
//            onItemClick?.invoke(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(player: List<Player>){
        items = player
    }

   class PlayerViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

       val playerName = itemView.findViewById<TextView>(R.id.player_name)
       val playerNumber = itemView.findViewById<TextView>(R.id.player_number)
       val playerPosition = itemView.findViewById<TextView>(R.id.player_position)
       val playerImage = itemView.findViewById<ImageView>(R.id.player_image)

       fun bind(player: Player) {
           playerName.setText(player.name)
           playerNumber.setText(player.number.toString())
           playerPosition.setText(player.position)
           playerImage.setBackgroundResource(player.image)

           val requestOptions = RequestOptions()
               .placeholder(R.drawable.ic_launcher_background)
               .placeholder(R.drawable.ic_launcher_background)


//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(requestOptions)
//                .load(player.image)
//                .into(playerImage)
       }
//       init {
//           itemView.setOnClickListener {
//               listener.onItemClick(adapterPosition)
//           }
//       }

   }
}