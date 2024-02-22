package com.example.lab_2.model

data class Question<T> (
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)