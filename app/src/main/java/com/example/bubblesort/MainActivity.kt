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
    private lateinit var randomButton: Button
    private lateinit var nums: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataTV = findViewById(R.id.dataTV)
        estimatedTimeTV = findViewById(R.id.estimatedTimeTV)
        dataSizeInput = findViewById(R.id.dataSizeInput)
        progressBar = findViewById(R.id.progressBar)

        var ran = Random()
        randomButton = findViewById(R.id.randomizeButton)
        randomButton.setOnClickListener {
            if (dataSizeInput.text.isEmpty()) {
                return@setOnClickListener
            }

            nums = (1..dataSizeInput.text.toString().toInt()).map { ran.nextInt() }
            dataTV.text = nums.toString()
        }

        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            if (dataSizeInput.text.isEmpty()) {
                Toast.makeText(this, "Data size cannot be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val startTime = System.currentTimeMillis()
            val bubbleSort = bubbleSort(nums as ArrayList<Int>, progressBar)
            val timeTaken = System.currentTimeMillis() - startTime

            dataTV.text = bubbleSort.toString()
            estimatedTimeTV.text = "Elapsed time: ${timeTaken.toString()}ms"
        }
    }
}