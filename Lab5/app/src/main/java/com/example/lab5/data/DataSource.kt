package com.example.lab5.data

import com.example.lab5.model.RadioStation

object DataSource {
    // Define a list of radio stations
    private val radioStations = listOf(
        RadioStation("Rock Station", "http://stream.rockantenne.de/90er-rock/stream/mp3"),
        RadioStation("Pop Station", "https://tx.planetradio.co.uk/http_live_bauerdk.php"),
        RadioStation("Hip Hop Station", "http://hydra.cdnstream.com/1525_128"),
        RadioStation("Reggaeton Station", "https://reggaeton.stream.laut.fm/reggaeton"),
        RadioStation("Country Station", "https://live.amperwave.net/direct/townsquare-keanfmmp3-ibc3.mp3&source=ts-tunein"),
        // Add more stations as needed
    )

    // Function to get all radio stations
    fun getRadioStations(): List<RadioStation> {
        return radioStations
    }
}
