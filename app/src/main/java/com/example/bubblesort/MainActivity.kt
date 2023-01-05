package com.example.bubblesort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var dataTV: TextView
    private lateinit var estimatedTimeTV: TextView
    private lateinit var dataSizeInput: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataTV = findViewById(R.id.dataTV)
        estimatedTimeTV = findViewById(R.id.estimatedTimeTV)
        dataSizeInput = findViewById(R.id.dataSizeInput)
        progressBar = findViewById(R.id.progressBar)

        var ran = Random()
        var nums = (1..dataSizeInput.text.toString().toInt()).map { ran.nextInt() }
        dataTV.text = nums.toString()

        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            if (dataSizeInput.text.isEmpty()) {
                Toast.makeText(this, "Data size cannot be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var nums = (1..dataSizeInput.text.toString().toInt()).map { ran.nextInt() }
            dataTV.text = nums.toString()

            val bubbleSort = bubbleSort(nums as ArrayList<Int>, progressBar)
            dataTV.text = bubbleSort.toString()
        }
    }
}