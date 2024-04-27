package com.example.lab6
import android.content.Context
import android.media.MediaPlayer

class AudioPlayer(context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    init {
        mediaPlayer = MediaPlayer()
    }

    fun play(audioUrl: String) {
        mediaPlayer?.apply {
            reset()
            setDataSource(audioUrl)
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

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
