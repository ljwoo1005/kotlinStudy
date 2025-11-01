package com.example.ch11

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ch11.databinding.ItemRecyclerview01Binding
import com.example.ch11.databinding.ItemRecyclerview02Binding

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
 * 리사이클러 뷰의 어댑터를 사용하는 방법
 *  1. 레이아웃 파일에 androidx.viewpager2.widget.ViewPager2 추가
 *  2. RecyclerView.Adapter 구현
 *  3. View Holder에 들어갈 페이지 레이아웃 XML 작성 (여기선 item_recyclerview02.xml)
 *      - 이 때, 레이아웃 XML의 root view는 가로, 세로 전부 match_parent를 사용해야 한다. (화면에 View가 꽉 차야함)
 *  4. Activity에서 Adapter 연결
 *  5. 필요 시 애니메이션, 오토슬라이드 등 확장 (여기선 안함)
 */

// 먼저 뷰 홀더를 만들어준다.
class MyPagerViewHolder(val binding: ItemRecyclerview02Binding): RecyclerView.ViewHolder(binding.root)

// 그리고 어댑터를 만들어준다. (ctrl + i 단축키로 메서드 오버라이딩)
class MyPagerAdapter(val dataList: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return MyPagerViewHolder(ItemRecyclerview02Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val binding = (holder as MyPagerViewHolder).binding // onCreateViewHolder의 반환값인 MyPagerViewHolder 클래스로 형변환

        // 뷰에 데이터 출력
        binding.recyclerTextView01.text = dataList[position]
        when(position % 3) {
            0 -> binding.recyclerTextView01.setBackgroundColor(Color.RED)
            1 -> binding.recyclerTextView01.setBackgroundColor(Color.BLUE)
            2 -> binding.recyclerTextView01.setBackgroundColor(Color.GREEN)
        }
    }

}

// 레이아웃의 ViewPager2 요소에 어댑터를 연결한다.
// Recycler View와는 다르게 LayoutManager를 사용하지 않는다.
class ViewPager2Recycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_recycler)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        // 리사이클러 뷰에 넣을 데이터 생성
        val dataList = mutableListOf<String>()

        for(i in 1..10) {
            dataList.add("item ${i}")
        }

        // 어댑터 연결
        viewPager2.adapter = MyPagerAdapter(dataList)

        // 방향 설정(가로 or 세로)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }
}