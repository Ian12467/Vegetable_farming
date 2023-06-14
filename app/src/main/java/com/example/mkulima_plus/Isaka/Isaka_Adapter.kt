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

class Isaka_Adapter(val context: Context, val attacks:List<Isaka_DataClass>,

                    )
    :RecyclerView.Adapter<Isaka_Adapter.attacks_Viewholder>()
{
    inner class attacks_Viewholder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val image:ImageView=itemView.findViewById(R.id.imageView_attacks)
        val attack_texts:TextView=itemView.findViewById(R.id.Isaka_attack_text)
        val name:TextView=itemView.findViewById(R.id.name_of_Crop)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): attacks_Viewholder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.datalayout_attacks,parent,false)
        return attacks_Viewholder(view)
    }
    override fun onBindViewHolder(holder: attacks_Viewholder, position: Int) {
        val Position=attacks[position]
        holder.name.text=Position.name
        holder.attack_texts.text= Position.AttackBio
        Glide.with(context)
            .load(Position.images)
            .into(holder.image)
        //Load Image
       // holder.image.setImageResource(Position.images)

    }
    override fun getItemCount(): Int {
        return attacks.size
    }
}
