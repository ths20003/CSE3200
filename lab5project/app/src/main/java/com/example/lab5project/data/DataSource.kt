package com.example.lab5project.data

import com.example.lab5project.R
import com.example.lab5project.model.RadioStation
class Datasource() {

    fun loadRadioStations(): List<RadioStation> {
        return listOf<RadioStation>(
            RadioStation(0, R.string.radio1_name, R.string.radio1_link, R.drawable.rock),
            RadioStation(0, R.string.radio2_name, R.string.radio2_link, R.drawable.country),
            RadioStation(0, R.string.radio3_name, R.string.radio3_link, R.drawable.pop),
            RadioStation(0, R.string.radio4_name, R.string.radio4_link, R.drawable.reggaeton),
            RadioStation(0, R.string.radio5_name, R.string.radio5_link, R.drawable.hiphop))
    }
}