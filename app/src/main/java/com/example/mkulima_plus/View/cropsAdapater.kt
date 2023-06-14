package com.example.mkulima_plus.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.example.mkulima_plus.view_Model.MainActivity

class cropsAdapater(val cropsData: ArrayList<cropsModel>, val listener: MainActivity) :
    RecyclerView.Adapter<cropsAdapater.crop_Viewholder>() {


    inner class crop_Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cropimage: ImageView = itemView.findViewById(R.id.crop_image)
        val name_of_crop: TextView = itemView.findViewById(R.id.crop_name)
        init {
            itemView.setOnClickListener {
                val position=adapterPosition
                listener.onclick(position)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): crop_Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cropsimages, parent, false)
        return crop_Viewholder(view)
    }

    override fun onBindViewHolder(holder: crop_Viewholder, position: Int) {
        val CropsData = cropsData[position]
        holder.cropimage.setImageResource(CropsData.images)
        holder.name_of_crop.text = CropsData.textname

    }
    override fun getItemCount(): Int {
        return cropsData.size
    }
    interface OnlickListener
    {
        fun onclick(position: Int)
    }

}