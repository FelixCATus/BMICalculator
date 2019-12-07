package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{ calculate() }

        buttonReset.setOnClickListener{ reset() }
    }

    private fun calculate(){
        if(editTextWeight.text.isNotEmpty() && editTextHeight.text.isNotEmpty()){
            val weight = editTextWeight.text.toString().toDouble()
            var height = editTextHeight.text.toString().toDouble()
            val bmi = weight / (height * height)
            textViewBMI.text = "BMI: " + bmi.toBigDecimal().setScale(2, RoundingMode.UP).toString()
            if(bmi < 18.5)
                imageViewProfile.setImageResource(R.drawable.under)
            else if(bmi >= 18.5 && bmi < 25)
                imageViewProfile.setImageResource(R.drawable.normal)
            else
                imageViewProfile.setImageResource(R.drawable.over)
        }
    }

    private fun reset(){
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        textViewBMI.text = "BMI: "
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}
