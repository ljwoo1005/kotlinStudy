package com.example.ch11

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val fragment01Button = findViewById<Button>(R.id.fragment01Button)
        val fragment02Button = findViewById<Button>(R.id.fragment02Button)

        /*
         * 프래그먼트 동적 제어 함수들
         * add(int containerViewId, Fragment fragment) : 새로운 프래그먼트를 화면에 추가한다.
         * replace(int containerViewId, Fragment fragment) : 추가된 프래그먼트를 대체한다.
         * remove(Fragment fragment) : 추가된 프래그먼트를 제거한다.
         * commit() : 화면에 적용한다.
         */
        fragment01Button.setOnClickListener {
            // 프래그먼트의 동적 제어를 위한 FragmentManager와 FragmentTransaction
            val fragmentManager: FragmentManager = supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentFrameLayout, Fragment01())

            transaction.commit()
        }
        fragment02Button.setOnClickListener {
            // 메서드 체이닝 방식
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentFrameLayout, Fragment02())
                .commit()
        }
    }
}