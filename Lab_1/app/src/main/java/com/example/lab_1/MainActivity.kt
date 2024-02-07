package com.example.lab_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.lab_1.ui.theme.Lab_1Theme

class MainActivity : ComponentActivity() {
    private val LOG_TYPE: String = "PGB_Log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(LOG_TYPE, "Message: In On Create")
        setContent {
            Lab_1Theme {
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TYPE, "Message: In On Pause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TYPE, "Message: In On Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TYPE, "Message: In On Stop")
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text(text = "Counter: $count")
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
    }
}
