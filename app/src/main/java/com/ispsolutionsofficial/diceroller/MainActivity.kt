package com.ispsolutionsofficial.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    var ivDice: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRoll: Button = findViewById(R.id.btnRoll)
        ivDice = findViewById(R.id.ivDice)
        ivDice?.setImageResource(R.drawable.dice_1)
        rollDice()
        btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice: Dice = Dice()
        val diceRolled: Int = dice.roll()
        val drawableResource = when(diceRolled) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        ivDice?.setImageResource(drawableResource)
        ivDice?.contentDescription = diceRolled.toString()
    }
}

class Dice(private val numSides: Int = 6) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}