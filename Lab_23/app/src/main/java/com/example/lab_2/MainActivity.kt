package com.example.lab_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_2.controller.QuestionsController
import com.example.lab_2.controller.ScoreController
import com.example.lab_2.controller.UserController
import com.example.lab_2.model.QuestionsModel
import com.example.lab_2.model.ScoreModel
import com.example.lab_2.model.UserModel
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var questionsController: QuestionsController
    private lateinit var scoreController: ScoreController
    private lateinit var userController: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionsList = listOf(
            "What is the capital of France?",
            "What is the largest mammal?",
            "What is the chemical symbol for water?",
            "Who wrote 'To Kill a Mockingbird'?",
            "What is the powerhouse of the cell?"
        )
        val questionsModel = QuestionsModel(questionsList)
        val scoreModel = ScoreModel()
        val userModel = UserModel()


        questionsController = QuestionsController(questionsModel)
        scoreController = ScoreController(scoreModel)
        userController = UserController(userModel)


        val currentQuestion = questionsController.getCurrentQuestion()
        val currentScore = scoreController.getScore()
        val currentUserId = userController.getUserId()


        updateUI(currentQuestion, currentScore, currentUserId)


        val nextQuestionButton = findViewById<Button>(R.id.nextQuestionButton)
        nextQuestionButton.setOnClickListener {
            questionsController.moveToNextQuestion()
            val newQuestion = questionsController.getCurrentQuestion()
            updateUI(newQuestion, currentScore, currentUserId)
        }

        val resetQuestionsButton = findViewById<Button>(R.id.resetQuestionsButton)
        resetQuestionsButton.setOnClickListener {
            questionsController.resetQuestions()
            val firstQuestion = questionsController.getCurrentQuestion()
            updateUI(firstQuestion, currentScore, currentUserId)
        }

        val incrementScoreButton = findViewById<Button>(R.id.incrementScoreButton)
        incrementScoreButton.setOnClickListener {
            scoreController.incrementScore()
            val newScore = scoreController.getScore()
            updateUI(currentQuestion, newScore, currentUserId)
        }

        val resetScoreButton = findViewById<Button>(R.id.resetScoreButton)
        resetScoreButton.setOnClickListener {
            scoreController.resetScore()
            val newScore = scoreController.getScore()
            updateUI(currentQuestion, newScore, currentUserId)
        }
    }

    private fun updateUI(question: String, score: Int, userId: String) {
        Log.d("MainActivity", "Question: $question, Score: $score, UserID: $userId")
    }
}
