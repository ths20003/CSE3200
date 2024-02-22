package com.example.lab_2.model

class AllQuestions {
    private val allQuestions = listOf(
        Question("What is the capital of France?", listOf("Paris", "London", "Berlin", "Rome"), "Paris", Difficulty.EASY),
        Question("Which planet is known as the Red Planet?", listOf("Mars", "Jupiter", "Saturn", "Venus"), "Mars", Difficulty.EASY),
        Question("What is the powerhouse of the cell?", listOf("Nucleus", "Mitochondria", "Ribosome", "Endoplasmic reticulum"), "Mitochondria", Difficulty.MEDIUM),
        Question("Who wrote 'To Kill a Mockingbird'?", listOf("Harper Lee", "F. Scott Fitzgerald", "Ernest Hemingway", "J.K. Rowling"), "Harper Lee", Difficulty.MEDIUM),
        Question("What is the chemical symbol for water?", listOf("H2O", "CO2", "NaCl", "O2"), "H2O", Difficulty.HARD),
        Question("Which country is known as the 'Land of the Rising Sun'?", listOf("China", "Japan", "South Korea", "Thailand"), "Japan", Difficulty.HARD)
    )

    fun getNumberOfQuestions(): Int = allQuestions.size

    fun getQuestion(index: Int): Question<String> = allQuestions[index].let {
        Question(it.questionText, it.options.map { option -> option.toString() }, it.correctAnswer.toString(), it.difficulty)
    }
}
