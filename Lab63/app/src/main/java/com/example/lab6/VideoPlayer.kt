package com.example.lab6

import android.content.Context
import android.media.MediaPlayer

class VideoPlayer(context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    init {
        mediaPlayer = MediaPlayer()
    }

    fun play(videoUrl: String) {
        mediaPlayer?.apply {
            reset()
            setDataSource(videoUrl)
            prepareAsync()
            setOnPreparedListener {
                start()
            }
        }
    }

    fun pause() {
        mediaPlayer?.pause()
    }

    fun stop() {
        mediaPlayer?.stop()
    }

    fun seekTo(position: Int) {
        mediaPlayer?.seekTo(position)
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
