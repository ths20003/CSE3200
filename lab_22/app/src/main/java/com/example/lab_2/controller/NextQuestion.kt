package com.example.lab_2.controller

import com.example.lab_2.model.AllQuestions
import kotlin.random.Random

object NextQuestion {
    private val totalQuestions: Int = AllQuestions().getNumberOfQuestions()
    private var currentQuestion: Int = 0

    fun getNextLinearQuestion(): Int {
        currentQuestion = (currentQuestion + 1) % totalQuestions
        return currentQuestion
    }

    fun getNextRandomQuestionNumber(): Int {
        return Random.nextInt(totalQuestions)
    }
}
