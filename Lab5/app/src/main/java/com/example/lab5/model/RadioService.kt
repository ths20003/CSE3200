package com.example.lab5.model

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import java.io.IOException

class RadioService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private val binder = RadioServiceBinder()

    inner class RadioServiceBinder : Binder() {
        fun getService(): RadioService {
            return this@RadioService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun playRadioStream(streamUrl: String) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
            mediaPlayer?.setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
        }

        try {
            mediaPlayer?.reset()
            mediaPlayer?.setDataSource(streamUrl)
            mediaPlayer?.prepareAsync()
            mediaPlayer?.setOnPreparedListener { mp ->
                mp.start()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun stopRadioStream() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
