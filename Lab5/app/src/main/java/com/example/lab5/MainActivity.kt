package com.example.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.adapters.RadioStationAdapter
import com.example.lab5.model.RadioStation

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RadioStationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assuming you have a list of radio stations
        val radioStations = listOf(
            RadioStation("Rock Station"),
            RadioStation("Pop Station"),
            RadioStation("Hip Hop Station"),
            RadioStation("Reggaeton Station"),
            RadioStation("Country Station")
        )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RadioStationAdapter(radioStations)
        recyclerView.adapter = adapter
    }
}

