package com.example.lab_2

object QuestionRepository {
    fun getQuestions(): List<Question> {
        // This could be a placeholder implementation
        return listOf(
            Question("What is the capital of France?"),
            Question("Who wrote 'Romeo and Juliet'?")
        )
    }
}
