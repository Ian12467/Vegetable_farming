package com.example.mkulima_plus.kunde

import android.content.Context
import android.icu.text.Transliterator.Position
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mkulima_plus.Managu.Crops_Dataclass
import com.example.mkulima_plus.R

class kundeAdapter(val context:Context,val cropdata:List<Crops_Dataclass>):RecyclerView.Adapter<kundeAdapter.viewholder>()
{
    inner class viewholder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val title_Text:TextView=itemView.findViewById(R.id.name_of_Crop)
        val image:ImageView=itemView.findViewById(R.id.kunde_image)
        val bio:TextView=itemView.findViewById(R.id.kunde_Bio)
        val Treat:TextView=itemView.findViewById(R.id.kunde_attack_treatment)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.kundedata_layout,parent,false)
        return viewholder(view)
    }
    override fun onBindViewHolder(holder: viewholder, position: Int)
    {
        val Position=cropdata[position]
        holder.title_Text.text=Position.name
        holder.bio.text=Position.Bio
        holder.Treat.text=Position.treatment
        Glide.with(context)
            .load(Position.images)
            .into(holder.image)
            }
    override fun getItemCount(): Int {
        return cropdata.size
    }


}