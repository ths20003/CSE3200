package com.example.lab_2.controller

import com.example.lab_2.model.Difficulty
import com.example.lab_2.model.Score

class ScoreController(private val name: String) {
    private val score = Score()

    fun incrementScore(difficulty: Difficulty) {
        val changeScore = when (difficulty) {
            Difficulty.EASY -> 1.0
            Difficulty.MEDIUM -> 2.0
            else -> 3.0
        }
        score += changeScore
    }

    fun getScore(): Double = score
}
