package com.example.timer

import com.example.timer.ui.notification.ViewNotification
import org.junit.Assert.assertEquals
import org.junit.Test


class TimerTestNotification {

    @Test
    fun testTimerFunctionality() {
        // Create an instance of ViewNotification
        val viewModel = ViewNotification()

        // Start the timer
        viewModel.startTimer()

        // Wait for a short period (simulate time passing)
        Thread.sleep(100)

        // Verify that the timer has increased
        assertEquals(1L, viewModel.timerValue.value)

        // Pause the timer
        viewModel.pauseTimer()

        // Wait for another short period
        Thread.sleep(1000)

        // Verify that the timer has not changed
        assertEquals(1L, viewModel.timerValue.value)

        // Reset the timer
        viewModel.resetTimer()

        // Verify that the timer has been reset
        assertEquals(0L, viewModel.timerValue.value)
    }
}
