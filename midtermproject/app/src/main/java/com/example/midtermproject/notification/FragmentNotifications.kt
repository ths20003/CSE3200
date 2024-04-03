package com.example.midtermproject.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.midtermproject.databinding.NotificationBinding
class FragmentNotifications : Fragment() {

    private var _binding: NotificationBinding? = null
    private val binding get() = _binding!!
    private lateinit var timer2ViewModel: ViewModelNotifications

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NotificationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        timer2ViewModel = ViewModelProvider(this).get(ViewModelNotifications::class.java)

        val timerTextView: TextView = binding.ViewTimerTextNotification
        timer2ViewModel.timerValue.observe(viewLifecycleOwner) {
            timerTextView.text = formatTime(it)
        }

        val startButton: Button = binding.StartButtonNotification
        startButton.setOnClickListener {
            timer2ViewModel.startTimer()
        }

        val pauseButton: Button = binding.PauseButtonNotification
        pauseButton.setOnClickListener {
            timer2ViewModel.pauseTimer()
        }

        val resetButton: Button = binding.ResetButtonNotification
        resetButton.setOnClickListener {
            timer2ViewModel.resetTimer()
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