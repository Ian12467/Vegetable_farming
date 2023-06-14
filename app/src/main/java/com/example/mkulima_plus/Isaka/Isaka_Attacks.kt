package com.example.mkulima_plus.Isaka
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
class Isaka_Attacks() : Fragment(R.layout.fragment_attacks)
{
    private lateinit var dbRef: FirebaseFirestore
     var AttacksData=ArrayList<Isaka_DataClass>()
    lateinit var recyclerView:RecyclerView
    lateinit var adapter: Isaka_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.Attacks_Recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()
        adapter = Isaka_Adapter(requireContext(),AttacksData)

        val menuHost: MenuHost = requireActivity()

        getAboutData()
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId){
            R.id.tips->{findNavController().navigate(R.id.action_fragment_attacks_to_tips)}
        }

        return false
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
    dbRef = FirebaseFirestore.getInstance() //get the database instance
    dbRef.collection("Saka").
        addSnapshotListener { value, error ->
    if (error != null) {
        Log.e("Firestone error ", error.message.toString())
    }
    for (dc: DocumentChange in value?.documentChanges!!)
    {
        if (dc.type == DocumentChange.Type.ADDED) {
            AttacksData.add(dc.document.toObject(Isaka_DataClass::class.java))
        }
    }
    adapter.notifyDataSetChanged()
}
    recyclerView.adapter = adapter
}
}


