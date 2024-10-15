package com.example.dz4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var firstOperandTE: EditText
    private lateinit var secondOperandTE: EditText

    private lateinit var sumButtonBTN: Button
    private lateinit var difButtonBTN: Button
    private lateinit var multButtonBTN: Button
    private lateinit var divButtonBTN: Button

    private lateinit var resultTV: TextView

    private lateinit var resetButtonBTN: Button
    private lateinit var exitButtonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstOperandTE = findViewById(R.id.festOperandET)
        secondOperandTE = findViewById(R.id.secondOperandET)

        sumButtonBTN = findViewById(R.id.buttonSumBTN)
        difButtonBTN = findViewById(R.id.buttonDifBTN)
        multButtonBTN = findViewById(R.id.buttonMultBTN)
        divButtonBTN = findViewById(R.id.buttonDivBTN)
        resetButtonBTN = findViewById(R.id.buttonResetBTN)
        exitButtonBTN = findViewById(R.id.buttonExitBTN)
        resultTV = findViewById(R.id.resultTV)
        sumButtonBTN.setOnClickListener(this)
        difButtonBTN.setOnClickListener(this)
        multButtonBTN.setOnClickListener(this)
        divButtonBTN.setOnClickListener(this)
        resetButtonBTN.setOnClickListener(this)
        exitButtonBTN.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        var check = true

        if (firstOperandTE.text.isEmpty() || secondOperandTE.text.isEmpty()) {
            return
        }
        val first = firstOperandTE.text.toString().toDouble()
        val second = secondOperandTE.text.toString().toDouble()

        val result = when (v.id) {
            R.id.buttonSumBTN -> Operation(first, second).sum()
            R.id.buttonDifBTN -> Operation(first, second).dif()
            R.id.buttonMultBTN -> Operation(first, second).mult()
            R.id.buttonDivBTN -> Operation(first, second).div()
            R.id.buttonResetBTN -> {
                firstOperandTE.text.clear()
                secondOperandTE.text.clear()
                check = false
            }
            R.id.buttonExitBTN -> finish()
            else -> 0.0
        }
        if (!check) resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}
