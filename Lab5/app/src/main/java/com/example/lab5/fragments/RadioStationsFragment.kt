package com.example.lab5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.adapters.RadioStationsAdapter
import com.example.lab5.data.DataSource
import com.example.lab5.R

class   RadioStationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_radio_stations, container, false)

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set adapter
        val radioStationsAdapter = RadioStationsAdapter(DataSource.getRadioStations())
        recyclerView.adapter = radioStationsAdapter

        return rootView
    }
}
