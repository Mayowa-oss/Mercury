package com.example.learnviewmodel

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val signalList: ArrayList<MessageItem>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = signalList[position]
        holder.profile.setImageResource(currentItem.profile)
        holder.description.text = currentItem.description
        holder.figures.text = currentItem.figures
        if (currentItem.figures == "NGN900,000.00") {
            holder.figures.setTextColor(Color.parseColor("#19AF16"))
        }

    }

    override fun getItemCount(): Int {
        return signalList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile: ShapeableImageView = itemView.findViewById(R.id.arrowprofile)
        val description: TextView = itemView.findViewById(R.id.description)
        val figures: TextView = itemView.findViewById(R.id.figures)
    }

}