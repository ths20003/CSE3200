package com.example.lab_2.controller
import com.example.lab_2.model.QuestionsModel

class QuestionsController(private val questionsModel: QuestionsModel) {

    fun getCurrentQuestion(): String {
        return questionsModel.getCurrentQuestion()
    }

    fun moveToNextQuestion() {
        questionsModel.moveToNextQuestion()
    }

    fun resetQuestions() {
        questionsModel.resetQuestions()
    }
}
