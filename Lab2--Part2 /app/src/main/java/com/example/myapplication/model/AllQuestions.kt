package com.example.myapplication.model

class AllQuestions {
    private val allQuestions = arrayListOf<Question<Boolean>>(
        Question<Boolean>("Objective morality can be proven via a secular point of view", false, Difficulty.MEDIUM),
        Question<Boolean>("11 + 2 = 21", false, Difficulty.EASY),
        Question<Boolean>("I think, therefore I am", true, Difficulty.EASY),
        Question<Boolean>("The scientific method cannot prove consciousness", true, Difficulty.HARD),
        Question<Boolean>("The Earth is flat", false, Difficulty.EASY),
        Question<Boolean>("Water boils at 100 degrees Fahrenheit", false, Difficulty.EASY),
        Question<Boolean>("Gravity is a theory, not a fact", true, Difficulty.MEDIUM),
        Question<Boolean>("The speed of light is constant in all frames of reference", true, Difficulty.HARD),
        Question<Boolean>("All living organisms require oxygen to survive", true, Difficulty.MEDIUM),
        Question<Boolean>("The human body has 206 bones", true, Difficulty.EASY)
    )

    fun getNumberOfQuestions() : Int {
        return allQuestions.size
    }

    fun getQuestion(i: Int) : Question<Boolean>{
        return allQuestions[i]
    }
}
