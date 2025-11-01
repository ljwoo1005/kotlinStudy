package com.example.ch11

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ch11.databinding.ActivityDrawerLayoutBinding
import com.google.android.material.navigation.NavigationView

class DrawerLayout : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)

        // XML에서 View 가져오기
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar) // 툴바를 액션바로 설정

        /*
         * DrawerLayout과 Toolbar를 연결할 토글 버튼 생성
         * 파라미터 : Activity, DrawerLayout, Toolbar, 드로어 열릴 때 안내 문자열 리소스, 드로어 닫힐 때 안내 문자열 리소스
         * 마지막 2개의 파라미터에 대해
         *  - 반드시 value/strings.xml 파일에 정의되어있는 문자열 리소스가 등록되어야 함
         *  - 눌렀을 때 실제로 해당 문자열이 눈에 보이는 것은 아니지만,
         *    스크린 리더같은 접근성 도우미를 사용하는 사용자에게 해당 문자열을 "음성으로 읽어주기 위해" 사용된다.
         */
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.drawer_open, R.string.drawer_close)

        // DrawerLayout에 토글 등록
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState() // 버튼과 드로어 상태 동기화

        // 네비게이션 메뉴 클릭 이벤트 처리
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.home -> {
                    // 홈 클릭
                    Toast.makeText(this, "홈 버튼 클릭", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    // 설정 클릭
                    Toast.makeText(this, "설정 버튼 클릭", Toast.LENGTH_SHORT).show()
                    true
                }
            }

            drawerLayout.closeDrawers() // 클릭 후 드로어 닫기
            true
        }

    }
}