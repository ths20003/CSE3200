package com.example.lab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_page) // Set the content view to your screen layout
        startActivity(Intent(this, ScreenActivity::class.java)) // Start the screen activity
        finish() // Finish the current activity to prevent returning to it
    }
}
