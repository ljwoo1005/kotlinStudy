package com.example.ch6_view.test1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch6_view.R

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test1)

        val text1 : TextView = findViewById(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)

        text1.text = "내가 문자열을 바꿨다"
        text2.text = "나도 문자열을 바꿨다"

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            if(button2.visibility == View.VISIBLE) {
                button2.visibility = View.INVISIBLE
            } else {
                button2.visibility = View.VISIBLE
            }

            if(button3.visibility == View.VISIBLE) {
                button3.visibility = View.INVISIBLE
            } else {
                button3.visibility = View.VISIBLE
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
}