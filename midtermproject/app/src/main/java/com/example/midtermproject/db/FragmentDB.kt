package com.example.midtermproject.db

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.midtermproject.databinding.DashboardBinding
class FragmentDB : Fragment() {
    private var _binding: DashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var timerViewModel: ViewModelDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        timerViewModel = ViewModelProvider(this).get(ViewModelDB::class.java)

        val timerTextView: TextView = binding.TimerTextViewdash
        timerViewModel.timerValue.observe(viewLifecycleOwner) {
            timerTextView.text = formatTime(it)
        }

        val startButton: Button = binding.StartDB
        startButton.setOnClickListener {
            timerViewModel.startTimer()
        }

        val pauseButton: Button = binding.PauseDB
        pauseButton.setOnClickListener {
            timerViewModel.pauseTimer()
        }

        val resetButton: Button = binding.ResetDB
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