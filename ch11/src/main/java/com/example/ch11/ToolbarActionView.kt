package com.example.ch11

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ToolbarActionView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_action_view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar) // 액션바의 내용을 툴바에 적용

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 툴바에 업 버튼 표시

    }

    // 액티비티 코드에 메뉴 XML 적용
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_action_view, menu)

        val menuItem = menu?.findItem(R.id.searchBar)
        val searchView = menuItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색어 변경 이벤트
                Log.d("LJW", "검색어 변경됨")

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                Log.d("LJW", "키보드 검색 버튼 누름")

                searchView.clearFocus() // 검색 버튼 클릭 이벤트가 2번씩 호출되는 현상 방지

                return true
            }
        })

        return true

    }



}