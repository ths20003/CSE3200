package com.example.lab_2.model

class Score {
    private var score: Double = 0.0
    private var totalQuestions: Int = 0

    fun incrementScore(scoreChange: Double) {
        totalQuestions++
        score += scoreChange
    }

    fun getScore(): Double = score
}
