package com.example.mkulima_plus.Managu
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mkulima_plus.R
class Managu_Adapter(val context:Context,val Data:List<Crops_Dataclass>)
    :RecyclerView.Adapter<Managu_Adapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val managu_Bio:TextView=itemView.findViewById(R.id.managu_Bio)
        val managu_Image:ImageView=itemView.findViewById(R.id.managu_image)
        val name:TextView=itemView.findViewById(R.id.name_of_Crop)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.managu_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Position=Data[position]
        holder.managu_Bio.text=Position.Bio
        Glide.with(context)
            .load(Position.images)
            .into(holder.managu_Image)
        //Load Image
         holder.name.text=Position.name
    }
    override fun getItemCount(): Int {
        return Data.size
    }
}
