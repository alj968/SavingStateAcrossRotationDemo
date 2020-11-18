package com.example.android.activitylifecyleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numOfCupcakesBought = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            numOfCupcakesBought = savedInstanceState.getInt(NUM_OF_CUPCAKES)

        val cupcakeButton: ImageButton = findViewById(R.id.dessert_button)
        cupcakeButton.setOnClickListener {
            numOfCupcakesBought++;
            updateCupcakes()
        }

        updateCupcakes()
    }

    private fun updateCupcakes() {
        val amtTextView : TextView = findViewById(R.id.amount_sold_text)
        amtTextView.text = "$numOfCupcakesBought"
        val totalTextView : TextView = findViewById(R.id.revenue_text)
        totalTextView.text = "$${numOfCupcakesBought * 3}"

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(NUM_OF_CUPCAKES, numOfCupcakesBought)
    }

    companion object {
        const val NUM_OF_CUPCAKES = "numOfCupcakes"
    }

}