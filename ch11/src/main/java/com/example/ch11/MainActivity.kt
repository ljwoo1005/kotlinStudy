package com.example.ch11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moveToolbar = findViewById<Button>(R.id.moveToolbar)
        val moveFragment = findViewById<Button>(R.id.moveFragment)
        val moveFragmentBackStack = findViewById<Button>(R.id.moveFragmentBackStack)

        moveToolbar.setOnClickListener {
            val intent = Intent(this, MainToolbar::class.java)
            startActivity(intent)
        }
        moveFragment.setOnClickListener {
            val intent = Intent(this, MainFragment::class.java)
            startActivity(intent)
        }
        moveFragmentBackStack.setOnClickListener {
            val intent = Intent(this, MainFragmentBackStack::class.java)
            startActivity(intent)
        }
    }
}