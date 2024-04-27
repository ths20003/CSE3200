package com.example.lab6

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var playVideoButton: Button
    private lateinit var toggleVideoButton: Button
    private lateinit var playAudioButton: Button
    private lateinit var toggleAudioButton: Button
    private var audioPlayer: MediaPlayer? = null
    private var currentVideoIndex = 0
    private var currentAudioIndex = 0

    private val videoResources = arrayOf(
        R.raw.sample,
        R.raw.lionsample
    )
    private val audioResources = arrayOf(
        R.raw.sample1,
        R.raw.fightclub,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()
        prepareResource(currentVideoIndex, isVideo = true)
        prepareResource(currentAudioIndex, isVideo = false)
    }

    private fun initViews() {
        videoView = findViewById(R.id.videoView)
        playVideoButton = findViewById(R.id.play_video_button)
        toggleVideoButton = findViewById(R.id.toggle_video_button)
        playAudioButton = findViewById(R.id.play_audio_button)
        toggleAudioButton = findViewById(R.id.toggle_audio_button)
    }

    private fun setupListeners() {
        playVideoButton.setOnClickListener {
            togglePlayback(videoView, playVideoButton)
        }

        toggleVideoButton.setOnClickListener {
            currentVideoIndex = (currentVideoIndex + 1) % videoResources.size
            prepareResource(currentVideoIndex, isVideo = true)
        }

        playAudioButton.setOnClickListener {
            togglePlayback(audioPlayer, playAudioButton)
        }

        toggleAudioButton.setOnClickListener {
            currentAudioIndex = (currentAudioIndex + 1) % audioResources.size
            prepareResource(currentAudioIndex, isVideo = false)
        }
    }

    private fun togglePlayback(player: Any?, button: Button) {
        when (player) {
            is MediaPlayer -> {
                if (!player.isPlaying) {
                    player.start()
                    button.text = getString(R.string.pause_audio)
                } else {
                    player.pause()
                    button.text = getString(R.string.play_audio)
                }
            }
            is VideoView -> {
                if (!player.isPlaying) {
                    player.start()
                    button.text = getString(R.string.pause_video)
                } else {
                    player.pause()
                    button.text = getString(R.string.play_video)
                }
            }
        }
    }


    private fun prepareResource(index: Int, isVideo: Boolean) {
        if (isVideo) {
            videoView.stopPlayback()
            val videoUri = getResourceUri(videoResources[index])
            videoView.setVideoURI(videoUri)
            videoView.setOnPreparedListener { mediaPlayer ->
                mediaPlayer.isLooping = true
                mediaPlayer.setVolume(0f, 0f)
                playVideoButton.text = getString(R.string.play_video)
            }
        } else {
            audioPlayer?.release()
            val audioUri = getResourceUri(audioResources[index])
            audioPlayer = MediaPlayer.create(this, audioUri).apply {
                isLooping = true
                playAudioButton.text = getString(R.string.play_audio)
                pause()
            }
        }
    }

    private fun getResourceUri(resourceId: Int): Uri {
        return Uri.parse("android.resource://${packageName}/$resourceId")
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.stopPlayback()
        audioPlayer?.release()
    }
}
