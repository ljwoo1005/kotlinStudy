package com.example.ch09

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowMetrics
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val screenSizeTextView = findViewById<TextView>(R.id.screenSize)

        // 안드로이드 30 버전부터는 WindowMetrics를 이용
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics

            // 휴대폰 스크린 사이즈를 추출 후 출력
            screenSizeTextView.text =
                "width : ${windowMetrics.bounds.width()}, height : ${windowMetrics.bounds.height()}"

        // 안드로이드 API 30 이전 버전에서는 DisplayMetrics로 크기 정보를 활용 (30버전 이후로는 deprecation)
        } else {

            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)

            // 휴대폰 스크린 사이즈를 추출 후 출력
            screenSizeTextView.text =
                "width : ${displayMetrics.widthPixels}, height : ${displayMetrics.heightPixels}"

        }

    }
}