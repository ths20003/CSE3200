// MainActivity.kt
package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var nextButton: Button

    private val scoreController = ScoreController()
    private val questionRepository = QuestionRepository
    private val userController = UserController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        nextButton = findViewById(R.id.nextButton)

        // Set up button click listener
        nextButton.setOnClickListener {
            // Increment score
            scoreController.incrementScore()
            // Update score text
            scoreTextView.text = "Score: ${scoreController.getScore().value}"
            // Fetch next question
            val questions = questionRepository.getQuestions()
            // Display next question (for simplicity, just display the first question)
            questionTextView.text = questions.firstOrNull()?.text ?: "No more questions"
        }

        // Set user ID (just for demonstration)
        userController.setUserId("123456")
    }
}
