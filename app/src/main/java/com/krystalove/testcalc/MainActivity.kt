package com.krystalove.testcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.round


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(v: View) {
        if(firstET.text.isEmpty()||secondET.text.isEmpty())
            Snackbar.make(findViewById(R.id.root_layout),R.string.snackbar_message_1,Snackbar.LENGTH_LONG).show()
        else {
            val op = (v as Button).text.toString()
            val firstNumb = firstET.text.toString().toDouble()
            val secondNumb = secondET.text.toString().toDouble()
            val result: Double = when (op) {
                "+" -> firstNumb + secondNumb
                "-" -> firstNumb - secondNumb
                "*" -> firstNumb * secondNumb
                "/" -> firstNumb / secondNumb
                else -> 0.0
            }
            if (result.toString() == "Infinity")
                Snackbar.make(findViewById(R.id.root_layout), R.string.snackbar_message_2, Snackbar.LENGTH_LONG).show()
            else
                resultTW.text = result.toString()
        }
    }
}
