package com.example.lab2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import com.example.lab2.R // Change this to your actual R file's package

class DoneActivity : AppCompatActivity() {

    private lateinit var textViewScore: TextView
    private lateinit var buttonRestartQuiz: Button
    private lateinit var buttonExitApp: Button

    private var score: Int = 0 // Assuming the score is calculated somewhere

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.done_page)

        // Initialize UI elements
        textViewScore = findViewById(R.id.textViewScore)
        buttonRestartQuiz = findViewById(R.id.buttonRestartQuiz)
        buttonExitApp = findViewById(R.id.buttonExitApp)

        // Display score
        textViewScore.text = getString(R.string.score_message, score)

        // Set OnClickListener for Restart Quiz button
        buttonRestartQuiz.setOnClickListener {
            // Restart the quiz (start the splash activity again)
            startActivity(Intent(this, ScreenActivity::class.java))
            finish() // Finish this activity
        }

        // Set OnClickListener for Exit App button
        buttonExitApp.setOnClickListener {
            // Close the app
            finishAffinity() // Finish all activities in the task
        }
    }
}
