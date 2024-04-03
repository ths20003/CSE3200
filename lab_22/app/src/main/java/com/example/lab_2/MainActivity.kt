package com.example.lab_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_2.controller.NextQuestion
import com.example.lab_2.controller.ScoreController
import com.example.lab_2.model.AllQuestions
import com.example.lab_2.model.UserId
import com.example.lab_2.ui.theme.Lab_2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_2Theme {
                QuizApp()
            }
        }
    }
}

@Composable
fun QuizApp() {
    val userId = remember { UserId("Toyi Shimizu") }
    val allQuestions = remember { AllQuestions() }
    val nextQuestion = remember { NextQuestion() }
    var questionNumber by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Welcome to quiz app, ${userId.getName()}")

        QuizComponent(
            question = allQuestions.getQuestion(questionNumber),
            onAnswerSelected = { isCorrect ->
                if (isCorrect) score++
                questionNumber = nextQuestion.getNextQuestionIndex()
            },
            onNextQuestion = {
                questionNumber = nextQuestion.getNextQuestionIndex()
            }
        )

        Text(text = "Score: $score", fontSize = 18.sp)
    }
}

@Composable
fun QuizComponent(
    question: String,
    onAnswerSelected: (Boolean) -> Unit,
    onNextQuestion: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = question,
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { onAnswerSelected(true) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("True")
                }
                Button(
                    onClick = { onAnswerSelected(false) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("False")
                }
            }

            Button(
                onClick = onNextQuestion,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp)
            ) {
                Text("Next Question")
            }
        }
    }
}
