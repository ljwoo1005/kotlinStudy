package com.example.ch11

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ToolbarBasic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_basic)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar) // 액션바의 내용을 툴바에 적용

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 툴바에 업 버튼 표시

    }

    // 툴바의 업 버튼 클릭 시 행위 재정의
    override fun onSupportNavigateUp(): Boolean {
        Log.d("LJW", "업 버튼 클릭")
        return super.onSupportNavigateUp()
    }

    // 툴바의 메뉴 구성 함수
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Menu.add(그룹Id, 아이템Id, 순서, 메뉴에 보여질 문자열)
        val menuItem1: MenuItem? = menu?.add(0, 0, 0, "menu1")
        val menuItem2: MenuItem? = menu?.add(0, 1, 0, "menu2")
        val menuItem3: MenuItem? = menu?.add(0, 2, 0, "menu3")
        return super.onCreateOptionsMenu(menu)
    }

    /* 메뉴 선택 시 이벤트 처리
     * return true일 때 : 내가 이벤트를 처리했다. -> 이벤트 전파 중단
     * return false일 때 : 내가 이벤트를 처리하지 않았다. -> 이벤트가 상위(Activity, Fragment, View 등)으로 전달됨
     * 상위로 전파되다가 처리할 곳이 없다면 이벤트가 "무시"되며, 아무런 반응이 없거나 시스템 기본 동작으로 넘어감.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        0 -> {
            Log.d("LJW", "menu1 click")
            true
        }
        1 -> {
            Log.d("LJW", "menu2 click")
            true
        }
        2 -> {
            Log.d("LJW", "menu3 click")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}