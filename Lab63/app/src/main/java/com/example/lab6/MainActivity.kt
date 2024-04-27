package com.example.lab6

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer()

        // Get resource ID of the video file
        val videoResourceId = resources.getIdentifier("sample", "raw", packageName)

        // Set data source to the MediaPlayer
        val videoUri = Uri.parse("android.resource://$packageName/$videoResourceId")
        mediaPlayer.setDataSource(this, videoUri)

        // Prepare the MediaPlayer
        mediaPlayer.prepare()

        // Find the button for playing video
        val btnPlayVideo: Button = findViewById(R.id.btnPlayVideo)

        // Set click listener for playing video
        btnPlayVideo.setOnClickListener {
            // Start playback
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release MediaPlayer resources
        mediaPlayer.release()
    }
}
