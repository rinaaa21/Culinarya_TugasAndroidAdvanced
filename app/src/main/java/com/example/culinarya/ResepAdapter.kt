package com.example.culinarya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ResepAdapter(private val resepList : ArrayList<Resep>, val listener: (Resep) -> Unit)
    : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.resep_item, parent, false)
        return ResepViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        holder.bindView(resepList[position],listener)

        val currentItem = resepList[position]
        holder.imageView.setImageResource(currentItem.imageResep)
        holder.titleResep.text = currentItem.titleResep
        holder.descResep.text = currentItem.descResep
        itemCount

    }

    override fun getItemCount(): Int {
        return resepList.size
    }

    class ResepViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.iv_img)
        val titleResep : TextView = itemView.findViewById(R.id.tv_title)
        val descResep : TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(Resep: Resep, listener: (Resep) -> Unit) {
            imageView.setImageResource(Resep.imageResep)
            titleResep.text = Resep.titleResep
            descResep.text = Resep.descResep
            itemView.setOnClickListener{
                listener(Resep)
            }
        }
    }
}