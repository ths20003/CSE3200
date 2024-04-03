package com.example.timer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class Timer1ViewModel : ViewModel() {

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private var timer: Timer? = null
    private var secondsElapsed: Long = 0
    private var isTimerRunning = false

    init {
        _currentTime.value = secondsElapsed
    }

    fun startTimer() {
        if (!isTimerRunning) {
            timer = Timer()
            timer?.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    secondsElapsed++
                    _currentTime.postValue(secondsElapsed)
                }
            }, 0, 1000)
            isTimerRunning = true
        }
    }

    fun pauseTimer() {
        timer?.cancel()
        isTimerRunning = false
    }

    fun resetTimer() {
        timer?.cancel()
        secondsElapsed = 0
        _currentTime.postValue(secondsElapsed)
        isTimerRunning = false
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}
