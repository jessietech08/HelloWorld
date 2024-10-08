package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.random.nextUInt

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

        // finds button by id
        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val scoreView = findViewById<TextView>(R.id.scoreView)

        // set two variables to random values
        var leftNum = Random.nextInt(1, 10)
        var rightNum = Random.nextInt(1, 10)
        while (leftNum == rightNum) {
            rightNum = Random.nextInt(1, 10)
        }
        buttonLeft.setText(leftNum.toString())
        buttonRight.setText(rightNum.toString())

        var score = 0

        // set the onClick listeners
        buttonLeft.setOnClickListener{
            leftNum = buttonLeft.getText().toString().toInt()
            rightNum = buttonRight.getText().toString().toInt()
            if (leftNum > rightNum) {
                score++
            }
            else {
                score--
            }
            scoreView.setText("Score: $score")

            leftNum = Random.nextInt(1, 10)
            rightNum = Random.nextInt(1, 10)
            while (leftNum == rightNum) {
                rightNum = Random.nextInt(1, 10)
            }
            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())
        }


        // set the onClick listeners
        buttonRight.setOnClickListener{
            leftNum = buttonLeft.getText().toString().toInt()
            rightNum = buttonRight.getText().toString().toInt()
            if (leftNum < rightNum) {
                score++
                Toast.makeText(this@MainActivity, "Win!", Toast.LENGTH_LONG).show()
            }
            else {
                score--
            }
            scoreView.setText("Score: $score")
            leftNum = Random.nextInt(1, 10)
            rightNum = Random.nextInt(1, 10)
            while (leftNum == rightNum) {
                rightNum = Random.nextInt(1, 10)
            }
            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())
        }


    }
}