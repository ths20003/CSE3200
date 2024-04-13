package com.example.lab5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.model.RadioStation
import com.example.lab5.R

class RadioStationsAdapter(private val radioStations: List<RadioStation>) :
    RecyclerView.Adapter<RadioStationsAdapter.RadioStationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioStationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio_station, parent, false)
        return RadioStationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RadioStationViewHolder, position: Int) {
        val station = radioStations[position]
        holder.bind(station)
    }

    override fun getItemCount(): Int {
        return radioStations.size
    }

    inner class RadioStationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val radioStationName: TextView = itemView.findViewById(R.id.radio_station_name)
        private val radioStationImage: ImageView = itemView.findViewById(R.id.radio_station_image)

        fun bind(radioStation: RadioStation) {
            radioStationName.text = radioStation.name
            // Load the corresponding image for the station
            val imageResId = itemView.context.resources.getIdentifier(
                radioStation.imageFileName,
                "drawable",
                itemView.context.packageName
            )
