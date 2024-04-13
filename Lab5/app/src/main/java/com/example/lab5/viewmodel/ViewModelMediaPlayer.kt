package com.example.lab5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab5.model.RadioService

class ViewModelMediaPlayer(private val radioService: RadioService) : ViewModel() {

    private val _isPlaying = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean>
        get() = _isPlaying

    init {
        _isPlaying.value = false
    }

    fun playRadioStream(streamUrl: String) {
        radioService.playRadioStream(streamUrl)
        _isPlaying.value = true
    }

    fun stopRadioStream() {
        radioService.stopRadioStream()
        _isPlaying.value = false
    }

    override fun onCleared() {
        super.onCleared()
        stopRadioStream()
    }
}
