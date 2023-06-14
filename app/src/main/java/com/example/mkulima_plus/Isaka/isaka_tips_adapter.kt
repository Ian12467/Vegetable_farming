package com.example.mkulima_plus.Isaka

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mkulima_plus.R

class isaka_tips_adapter(val context: Context, val tips:List<Isaka_Tips_DataClass>)
    :RecyclerView.Adapter<isaka_tips_adapter.isaka_viewholder>()
{
    inner class isaka_viewholder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val image: ImageView =itemView.findViewById(R.id.imageView_tips)
        val attack_texts: TextView =itemView.findViewById(R.id.Isaka_tips_text)
        //val name: TextView =itemView.findViewById(R.id.name_of_Crop)
        val stage:TextView=itemView.findViewById(R.id.stage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): isaka_viewholder
    {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.tips_layout,parent,false)
        return isaka_viewholder(view)
    }
    override fun onBindViewHolder(holder: isaka_viewholder, position: Int) {
        val Position=tips[position]
        holder.stage.text=Position.stage
        holder.attack_texts.text=Position.AttackBio
        Glide.with(context)
            .load(Position.images)
            .into(holder.image)
    }
    override fun getItemCount(): Int {
        return tips.size
    }
}