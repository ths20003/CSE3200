package com.example.lab6
import android.media.AudioAttributes
import android.media.MediaPlayer

class VideoPlayer {

    private var mediaPlayer: MediaPlayer = MediaPlayer()

    init {
        mediaPlayer.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
    }

    fun stopVideo() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
        }
    }

    fun playVideo(videoUri: String) {
        stopVideo()
        mediaPlayer.apply {
            reset()
            setDataSource(videoUri)
            setOnPreparedListener {
                it.start()
            }
            prepareAsync()
        }
    }

    fun release() {
        mediaPlayer.release()
    }
}
