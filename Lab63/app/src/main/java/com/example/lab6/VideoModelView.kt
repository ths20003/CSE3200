package com.example.lab6

import android.content.Context

class VideoModelView(private val context: Context, private val audioModelView: AudioModelView) {
    private val videoPlayer: VideoPlayer = VideoPlayer(context)

    fun playVideo(videoUrl: String) {
        videoPlayer.play(videoUrl)
    }

    fun pauseVideo() {
        videoPlayer.pause()
        audioModelView.pauseAudio() // Pause audio playback when video is paused
    }

    fun stopVideo() {
        videoPlayer.stop()
        audioModelView.stopAudio() // Stop audio playback when video is stopped
    }

    fun release() {
        videoPlayer.release()
        // No need to release audio resources here since it's handled by AudioModelView
    }
}
