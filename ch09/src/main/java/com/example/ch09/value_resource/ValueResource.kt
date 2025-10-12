package com.example.ch09.value_resource

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch09.R

class ValueResource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_value_resource)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val codeText = findViewById<TextView>(R.id.codeText)

        /*
         * values 디렉터리의 strings.xml 리소스 파일 내부에
         * 값을 지정한 태그의 name 속성값을 사용
         */
        codeText.text = getString(R.string.code_text)

        /*
         * values 디렉터리의 color.xml 리소스 파일 내부에
         * 값을 지정한 태그의 name 속성값을 사용
         * View.setTextColor() 함수 내부에 인자로
         * ResourcesCompat.getColor() 함수를 사용
         */
        codeText.setTextColor(ResourcesCompat.getColor(resources, R.color.green, null))

        /*
         * 안드로이드 플랫폼이 제공하는 리소스를 사용
         * android.R이라는 플랫폼 라이브러리의 R 파일에 등록되어있음
         */
        val platformText02 = findViewById<TextView>(R.id.platformText02)
        val platformImage02 = findViewById<ImageView>(R.id.platformImage02)

        platformText02.text = getString(android.R.string.emptyPhoneNumber)
        platformImage02.setImageDrawable(ResourcesCompat.getDrawable(resources, android.R.drawable.alert_dark_frame, null))
    }
}