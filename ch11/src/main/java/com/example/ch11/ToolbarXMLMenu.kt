package com.example.ch11

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ToolbarXMLMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_xml_menu)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar) // 툴바를 액션바로 설정

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 툴바에 업 버튼 표시

    }

    // 액티비티 코드에 메뉴 XML 적용
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 여기에서의 itemId는 XML에서 정의한 @+id/{id값}을 사용한다.
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu1 -> {
            Log.d("LJW", "1번 메뉴")
            true
        }
        R.id.add -> {
            Log.d("LJW", "+ 버튼")
            true
        }
        R.id.search -> {
            Log.d("LJW", "검색 버튼")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}