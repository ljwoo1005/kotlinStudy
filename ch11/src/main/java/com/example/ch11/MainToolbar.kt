package com.example.ch11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainToolbar : AppCompatActivity() /* AppCompatActivity 클래스로 안드로이드 앱의 화면을 구성하는 액티비티를 만들며 API레벨의 호환성 문제를 해결 */ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_toolbar)


        val toolbar01 = findViewById<Button>(R.id.toolbar01)

        toolbar01.setOnClickListener {
            val intent = Intent(this, ToolbarBasic::class.java)
            startActivity(intent)
        }

        val toolbarXmlMenu = findViewById<Button>(R.id.toolbarXmlMenu)

        toolbarXmlMenu.setOnClickListener {
            val intent = Intent(this, ToolbarXMLMenu::class.java)
            startActivity(intent)
        }

        val toolbarActionView = findViewById<Button>(R.id.toolbarActionView)

        toolbarActionView.setOnClickListener {
            val intent = Intent(this, ToolbarActionView::class.java)
            startActivity(intent)
        }
    }
}