package com.example.mkulima_plus.Managu

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class managu_Tips : Fragment(R.layout.fragment_managu__tips)
{
    private lateinit var dbRef: FirebaseFirestore
    var managuData = ArrayList<Crops_Dataclass>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Managu_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview_Tips)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()
        adapter = Managu_Adapter(requireContext(),managuData)
        getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
        dbRef = FirebaseFirestore.getInstance() //get the database instance
        dbRef.collection("Managu_Tips").addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestone error ", error.message.toString())
            }
            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    managuData.add(dc.document.toObject(Crops_Dataclass::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
        recyclerView.adapter = adapter
    }
    }
