package com.example.mkulima_plus.kunde

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Managu.Crops_Dataclass
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class kunde_About : Fragment(R.layout.fragment_kunde__about)
{
    lateinit var dbref: FirebaseFirestore
    lateinit var recyclerview: RecyclerView
    lateinit var adapter: kundeAdapter
    var kundaData = ArrayList<Crops_Dataclass>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview = view.findViewById(R.id.kunde_about_recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.hasFixedSize()
        adapter = kundeAdapter(requireContext(), kundaData)
        getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun getAboutData() {
        //get instance of the database
        dbref = FirebaseFirestore.getInstance()
        dbref.collection("kunde_About").addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestone error ", error.message.toString())
            }
            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    kundaData.add(dc.document.toObject(Crops_Dataclass::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
        recyclerview.adapter=adapter
    }
}