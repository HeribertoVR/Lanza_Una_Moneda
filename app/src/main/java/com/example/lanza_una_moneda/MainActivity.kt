package com.example.lanza_una_moneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener { lanza()}

        lanza()
    }

    private fun lanza(){
        //Create new Coin object with 30
        val vuelta = Coin(50)
        val giro = vuelta.roll()

        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        val lado = giro % 2

        //Determine wich drawable resource ID to use based on the dic roll
        val drawbleResource = when (lado){
            0 -> R.drawable.moneda1
            else -> R.drawable.moneda2
        }





        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawbleResource)

        //Update the content description
        diceImage.contentDescription = giro.toString()

    }

    class Coin (private val numVuelta: Int){

        fun roll(): Int{
            return (1..numVuelta).random()
        }
    }
}