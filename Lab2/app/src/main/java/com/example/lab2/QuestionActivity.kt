package com.example.lab2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    private lateinit var textViewQuestion: TextView
    private lateinit var buttonTrue: Button
    private lateinit var buttonFalse: Button

    private val questions = listOf(
        "Kotlin is a programming language.",
        "Android Studio is an Integrated Development Environment (IDE).",
        "XML is a programming language.",
        "Android is an operating system developed by Google."
    )

    // Assuming the correct answers for the questions
    private val correctAnswers = listOf(true, true, false, true)

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_page)

        // Initialize UI elements
        textViewQuestion = findViewById(R.id.textViewQuestion)
        buttonTrue = findViewById(R.id.buttonTrue)
        buttonFalse = findViewById(R.id.buttonFalse)

        // Display first question
        displayQuestion()

        // Set OnClickListener for True button
        buttonTrue.setOnClickListener {
            checkAnswer(true)
        }

        // Set OnClickListener for False button
        buttonFalse.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            textViewQuestion.text = questions[currentQuestionIndex]
        } else {
            // All questions answered, navigate to done page or handle accordingly
            // For now, just finish this activity
            finish()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = correctAnswers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            // User's answer is correct
            // You can add your logic here, such as updating the score
            // For now, just move to the next question
            currentQuestionIndex++
            displayQuestion()
        } else {
            // User's answer is incorrect
            // You can add your logic here, such as displaying a message
            // For now, just move to the next question
            currentQuestionIndex++
            displayQuestion()
        }
    }
}
