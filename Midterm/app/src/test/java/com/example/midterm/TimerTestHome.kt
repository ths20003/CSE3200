package com.example.midterm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.midterm.ui.home.ViewHome
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TimerTestHome {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: ViewHome

    @Before
    fun setup() {
        viewModel = ViewHome()
    }

    @Test
    fun testStartTimer() {
        viewModel.startTimer()
        // Wait for a short period (simulate time passing)
        Thread.sleep(1000)
        // Verify that the timer has increased
        assertEquals(1, viewModel.timerValue.value)
    }

    @Test
    fun testPauseTimer() {
        viewModel.startTimer()
        // Wait for a short period (simulate time passing)
        Thread.sleep(1000)
        viewModel.pauseTimer()
        // Get the current timer value
        val currentValue = viewModel.timerValue.value
        // Wait for another short period
        Thread.sleep(1000)
        // Verify that the timer value hasn't changed after pausing
        assertEquals(currentValue, viewModel.timerValue.value)
    }

    @Test
    fun testResetTimer() {
        viewModel.startTimer()
        // Wait for a short period (simulate time passing)
        Thread.sleep(1000)
        viewModel.resetTimer()
        // Verify that the timer value is reset to 0
        assertEquals(0, viewModel.timerValue.value)
    }
}