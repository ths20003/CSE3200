package com.example.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Timer1Fragment : Fragment() {
    private lateinit var viewModel: Timer1ViewModel
    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var stopPauseButton: Button
    private lateinit var resetButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(Timer1ViewModel::class.java)

        // Initialize views
        timerTextView = view.findViewById(R.id.timerTextView)
        startButton = view.findViewById(R.id.startButton)
        stopPauseButton = view.findViewById(R.id.stopPauseButton)
        resetButton = view.findViewById(R.id.resetButton)

        // Observe currentTime LiveData
        viewModel.currentTime.observe(viewLifecycleOwner) { currentTime ->
            // Update UI with currentTime
            timerTextView.text = formatTime(currentTime)
        }

        // Set up click listeners for buttons
        startButton.setOnClickListener {
            viewModel.startTimer()
        }

        stopPauseButton.setOnClickListener {
            viewModel.pauseTimer()
        }

        resetButton.setOnClickListener {
            viewModel.resetTimer()
        }

        return view
    }


    // Utility function to format time
    private fun formatTime(timeInSeconds: Long): String {
        val hours = timeInSeconds / 3600
        val minutes = (timeInSeconds % 3600) / 60
        val seconds = timeInSeconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
