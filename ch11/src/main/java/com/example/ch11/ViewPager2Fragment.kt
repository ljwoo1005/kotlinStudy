package com.example.ch11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

/*
 * 스와이프로 넘기는 화면 구성
 * 오랫동안 이용했던 viewpager와 별개로 2019년에 viewpager2를 제공함
 *
 * 항목이 순서대로 나열되어 있는데, 단지 한 화면에 하나의 항목만을 표출한다는 개념이다.
 * 어댑터는 2가지가 있다.
 *  1. 리사이클러 뷰에서 봤던 RecyclerView.Adapter
 *  2. 프래그먼트를 이용하는 FragmentStateAdapter
 */

/*
 * 프래그먼트 어댑터를 사용하는 방법
 *  1. 레이아웃 파일에 androidx.viewpager2.widget.ViewPager2 추가
 *  2. 페이지용 프래그먼트 생성
 *  3. FragmentStateAdapter 구현
 *  4. Activity에서 Adapter 연결
 *  5. 필요 시 애니메이션, 오토슬라이드 등 확장 (여기선 안함)
 */

// FragmentStateAdapter 구현
class MyPagerFragmentStateAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    val fragmentList = mutableListOf<Fragment>(Fragment01(), Fragment02())

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}

// Activity에서 Adapter 연결
class ViewPager2Fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_fragment)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        viewPager2.adapter = MyPagerFragmentStateAdapter(this)

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}