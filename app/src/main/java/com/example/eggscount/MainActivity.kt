package com.example.eggscount

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Link XML components to code
        val inputBox = findViewById<EditText>(R.id.InputBox)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val grossDisplay = findViewById<TextView>(R.id.GrossDisplay)
        val dozenDisplay = findViewById<TextView>(R.id.DozenDisplay)
        val eggDisplay = findViewById<TextView>(R.id.EggDisplay)

        val eggHandler = EggHandler()

        // 🔹 When user clicks "Calculate"
        calculateButton.setOnClickListener {
            val inputText = inputBox.text.toString()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val totalEggs = inputText.toIntOrNull()
            if (totalEggs == null || totalEggs < 0) {
                Toast.makeText(this, "Enter a valid positive number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = eggHandler.calculateEggs(totalEggs)

            // 🔹 Display result
            grossDisplay.text = "${result.gross}"
            dozenDisplay.text = "${result.dozens}"
            eggDisplay.text = "${result.eggs}"
        }
    }
}
