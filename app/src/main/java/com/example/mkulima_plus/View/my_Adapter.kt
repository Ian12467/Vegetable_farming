package com.example.mkulima_plus.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Model.DataModel
import com.example.mkulima_plus.R

class my_Adapter(val about_list: ArrayList<DataModel>):RecyclerView.Adapter<my_Adapter.my_ViewHolder>()

{
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): my_ViewHolder {
            val layout =LayoutInflater.from(parent.context).inflate(R.layout.about_crops, parent, false)
            return my_ViewHolder(layout)
        }
        override fun onBindViewHolder(holder: my_ViewHolder, position: Int) {
            val currentData = about_list[position]
            holder.about_the_crop.text=currentData.about_data
        }
        override fun getItemCount(): Int {
            return about_list.size
        }
    class my_ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val about_the_crop:TextView=itemView.findViewById(R.id.aboutCrop)
        val image_Crop = itemView.findViewById<ImageView>(R.id.cropImage)
    }
}