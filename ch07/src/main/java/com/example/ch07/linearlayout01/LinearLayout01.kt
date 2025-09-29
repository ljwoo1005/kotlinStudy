package com.example.ch07.linearlayout01

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch07.R

class LinearLayout01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_01_linear_layout01)

        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)
        val button3 : Button = findViewById(R.id.button3)
        val button4 : Button = findViewById(R.id.button4)

        button1.setOnClickListener {
            if(button3.visibility == View.VISIBLE) {
                button3.visibility = View.GONE;
            } else {
                button3.visibility = View.VISIBLE;
            }

            if(button4.visibility == View.VISIBLE) {
                button4.visibility = View.GONE;
            } else {
                button4.visibility = View.VISIBLE;
            }
        }

        button2.setOnClickListener {
            if(button3.visibility == View.VISIBLE) {
                button3.visibility = View.GONE;
            } else {
                button3.visibility = View.VISIBLE;
            }

            if(button4.visibility == View.VISIBLE) {
                button4.visibility = View.GONE;
            } else {
                button4.visibility = View.VISIBLE;
            }
        }

        button3.setOnClickListener {
            if(button1.visibility == View.VISIBLE) {
                button1.visibility = View.GONE;
            } else {
                button1.visibility = View.VISIBLE;
            }

            if(button2.visibility == View.VISIBLE) {
                button2.visibility = View.GONE;
            } else {
                button2.visibility = View.VISIBLE;
            }
        }

        button4.setOnClickListener {
            if(button1.visibility == View.VISIBLE) {
                button1.visibility = View.GONE;
            } else {
                button1.visibility = View.VISIBLE;
            }

            if(button2.visibility == View.VISIBLE) {
                button2.visibility = View.GONE;
            } else {
                button2.visibility = View.VISIBLE;
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}