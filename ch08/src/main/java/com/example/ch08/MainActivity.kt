package com.example.ch08

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /*
     * 터치 이벤트의 콜백 함수인 onTouchEvent()를 오버라이드
     * 매개변수는 MotionEvent 객체이며, 이 객체에 터치의 종류와 발생 지점(좌표값)이 담긴다.
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        /*
         * 터치 이벤트 종류
         * ACTION_DOWN : 화면을 손가락으로 누른 순간의 이벤트
         * ACTION_UP : 화면에서 손가락을 떼는 순간의 이벤트
         * ACTION_MOVE : 화면을 손가락으로 누른 채로 이동하는 순간의 이벤트
         */
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("LJW", "Touch down event")

                /*
                 * 터치 이벤트 발생 좌표 얻기
                 * onTouchEvent() 함수의 매개변수인 MotionEvent 객체로 획득
                 * x : 이벤트가 발생한 View의 X좌표
                 * y : 이벤트가 발생한 View의 Y좌표
                 * rawX : 화면의 X좌표
                 * rawY : 화면의 Y좌표
                 */
                Log.d("LJW", "Touch down event x : ${event.x}, rawX : ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("LJW", "Touch up event")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("LJW", "Touch move event")
            }
        }

        return super.onTouchEvent(event)
    }

    /*
     * 사용자가 폰의 키를 누르는 순간에 발생
     * 콜백 함수 종류
     * onKeyDown : 키를 누른 순간의 이벤트
     * onKeyUp : 키를 떼는 순간의 이벤트
     * onKeyLongPress : 키를 오래 누르는 순간의 이벤트
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("LJW", "onKeyDown")

        /*
         * 첫 번째 매개변수는 키의 코드이며, 이 값으로 사용자가 어떤 키를 눌렀는지 식별
         */
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                Log.d("LJW", "Volume Up Pressed")
                Toast.makeText(this, "Volume Up Pressed", Toast.LENGTH_SHORT).show()
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Log.d("LJW", "Volume Down Pressed")
                Toast.makeText(this, "Volume Down Pressed", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onKeyDown(keyCode, event)
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("LJW", "onKeyUp")
        return super.onKeyUp(keyCode, event)
    }
    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("LJW", "onKeyLongPress")
        return super.onKeyLongPress(keyCode, event)
    }

    /*
     * 뒤로가기 버튼 이벤트에는 onBackPressed() 함수를 이용할 수도 있다.
     * 하지만 API Level 33에서 deprecated
     * androidx.activity.OnBackPressedCallback 이용이 권장된다.
     * OnBackPressedCallback은 abstract class이다.
     * 먼저 익명 클래스 구현 후 Activity에 등록해준다.
     * 클래스 구현 시 생성자 인자인 isEnabled 값이 true일 때에만 호출된다.
     */
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // back key를 눌렀을 때 동작
            Log.d("LJW", "back key pressed")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 위의 OnBackPressedCallback 구현체를 등록
        // OnBackPressedCallback의 isEnabled = true일 때 뒤로가기 클릭 시 이벤트 발생
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)


    }


}