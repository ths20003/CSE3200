// ScoreController.kt
package com.example.lab_2

class ScoreController {
    private var score = Score()

    fun incrementScore() {
        score.value++
    }

    fun getScore(): Score {
        return score
    }
}
