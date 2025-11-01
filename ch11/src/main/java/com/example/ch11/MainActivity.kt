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
        val moveRecyclerView = findViewById<Button>(R.id.moveRecyclerView)
        val moveViewPager2RecyclerView = findViewById<Button>(R.id.moveViewPager2RecyclerView)
        val moveViewPager2Fragment = findViewById<Button>(R.id.moveViewPager2Fragment)
        val moveDrawerLayout = findViewById<Button>(R.id.moveDrawerLayout)

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
        moveRecyclerView.setOnClickListener {
            val intent = Intent(this, MainRecyclerView::class.java)
            startActivity(intent)
        }
        moveViewPager2RecyclerView.setOnClickListener {
            val intent = Intent(this, ViewPager2Recycler::class.java)
            startActivity(intent)
        }
        moveViewPager2Fragment.setOnClickListener {
            val intent = Intent(this, ViewPager2Fragment::class.java)
            startActivity(intent)
        }
        moveDrawerLayout.setOnClickListener {
            val intent = Intent(this, DrawerLayout::class.java)
            startActivity(intent)
        }
    }
}