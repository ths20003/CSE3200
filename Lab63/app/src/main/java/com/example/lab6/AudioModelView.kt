package com.example.lab6
import android.content.Context

class AudioModelView(private val context: Context) {
    private val audioPlayer: AudioPlayer = AudioPlayer(context)

    fun playAudio(audioUrl: String) {
        audioPlayer.play(audioUrl)
    }

    fun pauseAudio() {
        audioPlayer.pause()
    }

    fun stopAudio() {
        audioPlayer.stop()
    }

    fun release() {
        audioPlayer.release()
    }
}
