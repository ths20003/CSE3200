package com.example.lab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_page)

        val startButton = findViewById<Button>(R.id.buttonStartQuiz)
        startButton.setOnClickListener {
            // Start the quiz activity
            startActivity(Intent(this, QuestionActivity::class.java))
            // Finish this activity to prevent going back
            finish()
        }
    }
}
