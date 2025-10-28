package com.example.ch10

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // -------------------------------------- 토스트 메세지 --------------------------------------
        val toastButton = findViewById<Button>(R.id.toastButton)

        toastButton.setOnClickListener {

            // 토스트 메세지는 중복 클릭 시 queue에 저장되며, 최대 5개까지만 저장됨
            val toast = Toast.makeText(this, "토스트 메세지가 왔어요.", Toast.LENGTH_SHORT)

            toast.addCallback(
                object : Toast.Callback() {
                    // 토스트 메세지가 사라지기 시작할 때를 감지
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("LJW", "toast hidden")
                    }

                    // 토스트 메세지가 등장했을 때를 감지
                    override fun onToastShown() {
                        Log.d("LJW", "toast shown")
                    }
                }
            )

            toast.show()

        }
        // -------------------------------------- 토스트 메세지 END ----------------------------------

        // -------------------------------------- 날짜, 시간 ----------------------------------------
        val dialogButton = findViewById<Button>(R.id.dialogButton)

        dialogButton.setOnClickListener {

            // 날짜 다이얼로그 설정 후 타임 다이얼로그 순차적으로 실행시키기
            val context : MainActivity = this

            // month는 0부터 시작함. 0~11이니까 실제 month는 +1씩 해줘야함
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    Log.d("LJW", "year : ${year}, month : ${month+1}, dayOfMonth : ${dayOfMonth}")

                    TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
                        override fun onTimeSet(p0: TimePicker?, time: Int, minute: Int) {
                            Log.d("LJW", "time : ${time}, minute: ${minute}")
                        }
                    }, 15, 0, true).show()

                }
            }, 2025, 9, 28).show()

        }
        // -------------------------------------- 날짜, 시간 END-------------------------------------

        // -------------------------------------- 알림창 --------------------------------------------
        /*
         * 다이얼로그의 기본은 AlertDialog
         * 제목, 내용, 버튼 영역으로 구분됨
         * AlertDialog.Builder를 제공하므로 이 빌더를 이용해 알림창을 만든다.
         *
         * 함수 종류들
         * open fun setIcon(iconId: Int): AlertDialog.Builder!
         * open fun setTitle(title: CharSequence!): AlertDialog.Builder!
         * open fun setMessage(message: CharSequence!): AlertDialog.Builder!
         *
         * 알림창에 버튼을 지정하는 함수
         * open fun setPositiveButton(text: CharSequence!, listener: DialogInterface.OnClickListener!): AlertDialog.Builder!
         * open fun setNegativeButton(text: CharSequence!, listener: DialogInterface.OnClickListener!): AlertDialog.Builder!
         * open fun setNeutralButton(text: CharSequence!, listener: DialogInterface.OnClickListener!): AlertDialog.Builder!
         */
        val alertButton01 = findViewById<Button>(R.id.alertButton01)

        alertButton01.setOnClickListener {

            AlertDialog.Builder(this).run {
                setTitle("테스트 알림창01")
                setIcon(android.R.drawable.ic_dialog_info) // 안드로이드 플랫폼 리소스 사용
                setMessage("정말 종료하시겠습니까???????????????????")
                setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    // dialog : 현재 다이얼로그 객체. dialog.dismiss()로 닫을 수 있다.
                    // which : 어떤 버튼이 눌렸는지 나타내는 상수
                    Log.d("LJW", "click button : ${which}")
                })
                setNegativeButton("Cancel", { dialog, which ->
                    Log.d("LJW", "click button : ${which}")
                })
                setNeutralButton("More", { dialog, which ->
                    Log.d("LJW", "click button : ${which}")
                })
                show()
            }

        }

        // 버튼의 이벤트 핸들러 등록
        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, buttonType: Int) {
                when(buttonType) {
                    DialogInterface.BUTTON_POSITIVE -> { Log.d("LJW", "positive button click") }
                    DialogInterface.BUTTON_NEGATIVE -> { Log.d("LJW", "negative button click") }
                    DialogInterface.BUTTON_NEUTRAL -> { Log.d("LJW", "neutral button click") }
                }
            }
        }

        val alertButton02 = findViewById<Button>(R.id.alertButton02)

        alertButton02.setOnClickListener {

            AlertDialog.Builder(this).run {
                setTitle("테스트 알림창02")
                setIcon(android.R.drawable.ic_dialog_info) // 안드로이드 플랫폼 리소스 사용
                setMessage("정말 종료 안하시겠습니까????????????")
                setPositiveButton("OK", eventHandler)
                setNegativeButton("Cancel", eventHandler)
                setNeutralButton("More", eventHandler)
                show()
            }

        }
        // -------------------------------------- 알림창 END-----------------------------------------
    }


}