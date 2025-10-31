package com.example.ch11

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainFragmentBackStack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_back_stack)

        val fragment01Button = findViewById<Button>(R.id.fragment01Button)
        val fragment02Button = findViewById<Button>(R.id.fragment02Button)

        /*
         * 프래그먼트 백스택
         * 뒤로가기 버튼을 눌렀을 때 이전 프래그먼트로 돌아갈 수 있음
         */
        fragment01Button.setOnClickListener {
            // 프래그먼트의 동적 제어를 위한 FragmentManager와 FragmentTransaction
            val fragmentManager: FragmentManager = supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentFrameLayout, Fragment01())
            transaction.addToBackStack(null)

            transaction.commit()
        }
        fragment02Button.setOnClickListener {
            // 메서드 체이닝 방식
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentFrameLayout, Fragment02())
                .addToBackStack(null)
                .commit()
        }
    }
}