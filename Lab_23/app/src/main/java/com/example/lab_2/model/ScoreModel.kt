package com.example.lab_2.model

class ScoreModel {
    private var score = 0

    fun getScore(): Int {
        return score
    }

    fun incrementScore() {
        score++
    }

    fun resetScore() {
        score = 0
    }
}
