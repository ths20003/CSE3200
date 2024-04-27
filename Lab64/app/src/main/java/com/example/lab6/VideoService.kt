package com.example.lab6
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder

class VideoService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private val binder = VideoBinder()

    inner class VideoBinder : Binder() {
        fun getService(): VideoService = this@VideoService
    }

    override fun onBind(intent: Intent): IBinder = binder

    fun playVideo(videoUri: String) {
        stopVideo()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(this@VideoService, Uri.parse(videoUri))
            setOnPreparedListener {
                it.start()
            }
            prepareAsync()
        }
    }

    fun stopVideo() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
            mediaPlayer = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopVideo()
    }
}
