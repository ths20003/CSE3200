package com.example.midterm.ui.db

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.midterm.databinding.FragmentDashboardBinding

class FragmentDB : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var timerViewModel: ViewDB

    // Getter method for timerViewModel
    fun getTimerViewModel(): ViewDB {
        return timerViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        timerViewModel = ViewModelProvider(this).get(ViewDB::class.java)

        val timerTextView: TextView = binding.dashboardTimerTextView
        timerViewModel.timerValue.observe(viewLifecycleOwner) {
            timerTextView.text = formatTime(it)
        }

        val startButton: Button = binding.dashboardStartButton
        startButton.setOnClickListener {
            timerViewModel.startTimer()
        }

        val pauseButton: Button = binding.dashboardPauseButton
        pauseButton.setOnClickListener {
            timerViewModel.pauseTimer()
        }

        val resetButton: Button = binding.dashboardResetButton
        resetButton.setOnClickListener {
            timerViewModel.resetTimer()
        }

        return root
    }

    fun formatTime(timeInSeconds: Long): String {
        val hours = timeInSeconds / 3600
        val minutes = (timeInSeconds % 3600) / 60
        val seconds = timeInSeconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
