package com.example.mkulima_plus.Isaka
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
class Isaka_Tips : Fragment(R.layout.fragment_tips) {
    private lateinit var dbRef: FirebaseFirestore
    var TipsData= ArrayList<Isaka_Tips_DataClass>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: isaka_tips_adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.tips_Recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()
        adapter = isaka_tips_adapter(requireContext(),TipsData)
        getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
        dbRef = FirebaseFirestore.getInstance() //get the database instance
        dbRef.collection("Isaka_Tips").
        addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestone error ", error.message.toString())
            }
            for (dc: DocumentChange in value?.documentChanges!!)
            {
                if (dc.type == DocumentChange.Type.ADDED) {
                  TipsData.add(dc.document.toObject(Isaka_Tips_DataClass::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
        recyclerView.adapter = adapter
    }
}

