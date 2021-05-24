package com.nephat.kotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        }

    }

    private fun rollDice() {
        val myDice = Dice(6)
        val rollResult = myDice.roll()
        //val result = "Result: $rollResult"
        val mDiceImage: ImageView = findViewById(R.id.diceImage)

        val drawableResource = when (rollResult){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5

            else -> R.drawable.dice_6
        }
        mDiceImage.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int){
    fun roll(): Int {
        return (1..numSides).random()
    }
}