
package com.example.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Timer3Fragment : Fragment() {
    private lateinit var viewModel: Timer3ViewModel
    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var stopPauseButton: Button
    private lateinit var resetButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        viewModel = ViewModelProvider(this).get(Timer3ViewModel::class.java)

        timerTextView = view.findViewById(R.id.timerTextView)
        startButton = view.findViewById(R.id.startButton)
        stopPauseButton = view.findViewById(R.id.stopPauseButton)
        resetButton = view.findViewById(R.id.resetButton)

        viewModel.currentTime.observe(viewLifecycleOwner) { currentTime ->
            timerTextView.text = formatTime(currentTime)
        }

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

    private fun formatTime(timeInSeconds: Long): String {
        val hours = timeInSeconds / 3600
        val minutes = (timeInSeconds % 3600) / 60
        val seconds = timeInSeconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
