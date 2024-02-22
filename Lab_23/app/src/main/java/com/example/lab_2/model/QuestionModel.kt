// QuestionsModel.kt
package com.example.lab_2.model

class QuestionsModel(private val questions: List<String>) {
    private var currentQuestionIndex = 0

    fun getCurrentQuestion(): String {
        return questions[currentQuestionIndex]
    }

    fun moveToNextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
    }

    fun resetQuestions() {
        currentQuestionIndex = 0
    }
}
