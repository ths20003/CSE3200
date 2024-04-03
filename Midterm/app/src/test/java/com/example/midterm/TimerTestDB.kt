package com.example.midterm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.midterm.ui.db.FragmentDB
import com.example.midterm.ui.db.ViewDB
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TimerTestDB {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var fragment: FragmentDB
    private lateinit var viewModel: ViewDB

    @Before
    fun setup() {
        fragment = FragmentDB()
        viewModel = fragment.getTimerViewModel() // Accessing timerViewModel using the getter method
    }

    @Test
    fun `test formatTime`() {
        val formattedTime = fragment.formatTime(3661)
        assertEquals("01:01:01", formattedTime)
    }

    @Test
    fun testTimerFunctionality() {
        // Start the timer manually
        viewModel.startTimer()

        // Wait for a short period (simulate time passing)
        Thread.sleep(100)

        // Verify that the timer has increased
        assertEquals(1, viewModel.timerValue.value)

        // Pause the timer manually
        viewModel.pauseTimer()

        // Wait for another short period
        Thread.sleep(1000)

        // Verify that the timer has not changed
        assertEquals(1, viewModel.timerValue.value)

        // Reset the timer manually
        viewModel.resetTimer()

        // Verify that the timer has been reset
        assertEquals(0, viewModel.timerValue.value)
    }
}