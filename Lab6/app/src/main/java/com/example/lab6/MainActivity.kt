package com.example.lab06

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(clickListener)
        binding.button2.setOnClickListener(clickListener)
        binding.button3.setOnClickListener(clickListener)
        binding.button4.setOnClickListener(clickListener)
    }

    private val clickListener = View.OnClickListener { view ->
        val audioUrl = when (view.id) {
            R.id.button1 -> "https://github.com/rafaelreis-hotmart/Audio-Sample-files/raw/master/sample.mp3"
            R.id.button2 -> "https://audio-edge-qse4n.yyz.g.radiomast.io/ref-128k-mp3-stereo"
            R.id.button3 -> "https://github.com/rafaelreis-hotmart/Audio-Sample-files/raw/master/sample.mp3"
            R.id.button4 -> "https://audio-edge-qse4n.yyz.g.radiomast.io/ref-128k-mp3-stereo"
            else -> ""
        }
        val videoUrl = when (view.id) {
            R.id.button1 -> "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            R.id.button2 -> "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
            R.id.button3 -> "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            R.id.button4 -> "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
            else -> ""
        }
        startMediaPlayer(audioUrl, videoUrl)
    }


    private fun startMediaPlayer(audioUrl: String, videoUrl: String) {
        val intent = Intent(this, MediaPlayer::class.java)
        intent.putExtra("audioUrl", audioUrl)
        intent.putExtra("videoUrl", videoUrl)
        startActivity(intent)
    }



}