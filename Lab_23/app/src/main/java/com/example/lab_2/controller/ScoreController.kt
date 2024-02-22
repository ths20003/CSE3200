package com.example.lab_2.controller
import com.example.lab_2.model.ScoreModel

class ScoreController(private val scoreModel: ScoreModel) {

    fun getScore(): Int {
        return scoreModel.getScore()
    }

    fun incrementScore() {
        scoreModel.incrementScore()
    }

    fun resetScore() {
        scoreModel.resetScore()
    }
}
