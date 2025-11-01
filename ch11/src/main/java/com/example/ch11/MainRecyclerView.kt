package com.example.ch11

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ch11.databinding.ActivityMainRecyclerViewBinding
import com.example.ch11.databinding.ItemRecyclerview01Binding


/*
 * 리사이클러란 : 안드로이드 앱에서 리스트 형태의 데이터를 표시하는데 사용되는 위젯이다.
 * 여러 아이템을 스크롤 가능한 리스트로 표현하며, 많은 아이템을 효율적으로 관리하고 보여주는 역할을 한다.
 *
 * Recycle -> 재활용
 * View를 재활용하여 사용하는 방법.
 *
 * 리스트 형태로 데이터를 표현하는 방법으로는 ListView라는 것이 있는데, 둘의 차이점을 비교해보자.
 *
 * ListView
 *  - 스크롤할 때 마다 위에 있던 아이템이 삭제되고 맨 아래 아이템이 생성되는 과정이 반복된다.
 *  - 아이템 개수만큼 삭제와 생성이 반복되어 성능이 좋지 않다.
 *
 * RecyclerView
 *  - 스크롤할 때 마다 위에 있던 아이템이 재활용되어 아래로 이동하여 재사용된다.
 *  - 예를 들어 10개 정도 View를 만들고, 10개의 View를 재활용하여 사용한다.
 *  - View를 계속 만드는 ListView의 단점을 보완할 수 있다.
 *
 * 리사이클러 뷰를 사용하기 위해 ViewBinding을 사용한다. (build.gradle.kts의 android 영역에서 viewBinding.isEnabled = true 설정)
 *
 * 리사이클러 뷰 기초 사용법
 * 구성 요소
 *  1. ViewHolder(필수)
 *      - 아이템 View를 보유(저장)하고 표시하는 역할을 한다.
 *      - 스크롤해서 위로 올라간 View를 재활용하기 위해 View를 기억하는 역할을 한다.
 *  2. Adapter(필수)
 *      - 데이터를 목록 형태로 보여주기 위해 사용된다.
 *      - 데이터를 아이템 View와 연결하는 역할을 한다.
 *      - 데이터와 RecyclerView 사이의 통신을 위한 연결체이다.
 *  3. LayoutManager(필수)
 *      - 데이터나 아이템들이 RecyclerView 내부에서 배치되는 형태(방식)을 관리한다.
 *      - LinearLayoutManager : 수평, 수직으로 배치
 *      - GridLayoutManager : 그리드(격자) 화면으로 배치
 *      - StaggeredGridLayoutManager : 높이가 불규칙한 그리드(격자) 화면으로 배치
 *  4. ItemDecoration(옵션) : 항목을 꾸민다.
 */

/*
 * 가장 먼저 뷰 홀더를 준비한다.
 */
class MyViewHolder(val binding: ItemRecyclerview01Binding): RecyclerView.ViewHolder(binding.root)

/*
 * 그 다음 어댑터를 준비한다.
 * 생성자 요소로 리사이클러 뷰에 배치할 데이터 리스트를 전달한다.
 * 아래 3개의 함수는 abstract method로, 어댑터 생성과 함께 직접 구현해야 한다.
 * getItemCount() : 항목 개수를 판단하려고 자동으로 호출된다.
 * onCreateViewHolder() : 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출된다.
 * onBindViewHolder() : 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출된다.
 */
class MyAdapter(val dataList: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        // 리스트로 배치할 뷰 항목의 개수를 반환
        return dataList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 아이템 View 구성에 필요한 뷰 홀더 객체 준비
        // 여기서 반환한 뷰 홀더 객체는 자동으로 아래의 onBindViewHolder() 함수의 매개변수로 전달된다.
        return MyViewHolder(ItemRecyclerview01Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("LJW", "onBindViewHolder : ${position}") // position : 데이터 리스트의 인덱스
        val binding = (holder as MyViewHolder).binding // 위의 onCreateViewHolder() 함수 반환값인 MyViewHolder로 형변환 : 뷰 홀더 안의 아이템 View들을 bind

        // 뷰에 데이터 출력
        binding.recyclerTextView01.text = dataList[position]
        // 뷰에 이벤트 추가
        binding.recyclerTextView01.setOnClickListener {
            Log.d("LJW", "아이템 텍스트 클릭 : ${position + 1}")
        }
    }
}

/*
 * 선택사항으로 Item Decoration을 사용할 수 있다.
 * 리사이클러 뷰를 다양하게 꾸밀 때 사용한다.
 * 여기선 항목의 구분선을 출력해주는 DividerItem Decoration을 사용해보자.
 *
 * ItemDecoration을 상속받는 개발자 클래스를 만들고, 이 클래스에서 다양한 꾸미기 작업을 한다.
 *  - onDraw() : 항목이 배치되기 전에 호출된다.
 *  - onDrawOver() : 항목이 모두 배치된 후에 호출된다.
 *  - getItemOffsets() : 항목이 배치되기 전에 개별 항목을 꾸밀 때 호출된다.
 * 호출 순서 : getItemOffsets -> onDraw -> onDrawOver
 */
class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        // 항목이 배치되기 전에 배경에 이미지 삽입
        c.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.stadium),
            0f, 0f, null)
    }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        // 항목이 배치된 후 리사이클러 뷰의 크기를 계산하여 이미지 삽입

        // 리사이클러 뷰 크기 계산
        val width = parent.width
        val height = parent.height
        // 이미지 크기 계산
        val dr: Drawable? = ResourcesCompat.getDrawable(context.getResources(),
            R.drawable.kbo, null)
        val drWidth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight

        // 이미지가 그려질 위치 계산
        val left = width / 2 - drWidth?.div(2) as Int
        val top = height / 2 - drHeight?.div(2) as Int

        // 이미지 삽입
        c.drawBitmap(
            BitmapFactory.decodeResource(context.getResources(), R.drawable.kbo),
            left.toFloat(), top.toFloat(), null)

    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val index = parent.getChildAdapterPosition(view) + 1

        // 요소 3개마다 아래쪽으로 간격 띄우기
        if( index % 3 == 0 ) {
            outRect.set(10, 10, 10, 60) // left, top, right, bottom
        } else {
            outRect.set(10, 10, 10, 0)
        }

        // 요소의 배경 컬러 변경
        view.setBackgroundColor(Color.LTGRAY)
        // 이미지 위에 뷰 객체가 보일 수 있도록 z축 띄우기
        ViewCompat.setElevation(view, 20.0f)
    }
}


/*
 * 마지막으로 레이아웃 매니저를 사용하여 어댑터로 구성한 항목을 배치한다.
 */
class MainRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러 뷰의 리스트를 구성할 데이터 생성
        val dataList = mutableListOf<String>(
            "item 1",
            "item item 2",
            "item item item 3",
            "item item item item 4",
            "item item item item item 5",
            "item item item item item item 6",
            "item item item item item item item 7",
            "item item item item item item item item 8",
            "item item item item item item item item item 9")


        // 리사이클러 뷰에 어댑터 연결
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = MyAdapter(dataList)

        // 리사이클러 뷰에 위에서 정의한 Item Decoration 적용
        recyclerView.addItemDecoration(MyDecoration(this))

        /*
         * 레이아웃 매니저의 배치 적용 방법
         * LinearLayoutManager(context, 배치 방향, 배치 순서)
         *
         *  context : 레이아웃 클래스 객체
         *  배치 방향 : 수직 or 수평 ( VERTICAL or HORIZONTAL )
         *  배치 순서 : 역방향 여부 ( true or false )
         *
         *  - LinearLayoutManager(this) : 수직이면서 정방향 배치 (위 -> 아래)
         *  - LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL false) : 수평이면서 정방향 배치 (왼쪽 -> 오른쪽)
         *
         * GridLayoutManager(context, 격자 개수, 배치 방향, 배치 순서)
         *
         *  - GridLayoutManager(this, 3) : 수직이면서 정방향으로 3개 배치 (위 -> 아래)
         *  - GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false) : 수평이면서 역방향으로 3개 배치 (왼쪽 -> 오른쪽)
         *
         * StaggeredGridLayoutManager(격자 개수, 배치 방향)
         * StaggeredGridLayout은 View의 크기가 다르면 지그재그 형태로 배치한다.
         *
         *  - StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL) : 수직이면서 정방향 3개 배치
         */
        recyclerView.layoutManager = LinearLayoutManager(this) // 수직 정방향 배치

        // 버튼 클릭 시 리사이클러 뷰 내부의 리스트 추가
        val addDataButton = findViewById<Button>(R.id.addDataButton)
        var newItemIdx = 0

        addDataButton.setOnClickListener {
            dataList.add("New Item ${++newItemIdx}")

            // 리스트에 데이터 추가 후 어댑터에 추가된 데이터 적용
            recyclerView.adapter?.notifyDataSetChanged()
        }

        // 버튼 클릭 시 리사이클러 뷰의 레이아웃 변경
        val changeVerticalLinearLayoutButton = findViewById<Button>(R.id.changeVerticalLinearLayoutButton)
        val changeHorizontalLinearLayoutButton = findViewById<Button>(R.id.changeHorizontalLinearLayoutButton)
        val changeVerticalGridLayoutButton = findViewById<Button>(R.id.changeVerticalGridLayoutButton)
        val changeHorizontalGridLayoutButton = findViewById<Button>(R.id.changeHorizontalGridLayoutButton)
        val changeVerticalStaggeredGridLayoutButton = findViewById<Button>(R.id.changeVerticalStaggeredGridLayoutButton)
        val changeHorizontalStaggeredGridLayoutButton = findViewById<Button>(R.id.changeHorizontalStaggeredGridLayoutButton)

        val verticalLinearLayoutManager = LinearLayoutManager(this)
        val horizontalLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val verticalGridLayoutManager = GridLayoutManager(this, 3)
        val horizontalGridLayoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true)

        val verticalStaggeredGridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val horizontalStaggeredGridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)

        changeVerticalLinearLayoutButton.setOnClickListener {
            recyclerView.layoutManager = verticalLinearLayoutManager
        }
        changeHorizontalLinearLayoutButton.setOnClickListener {
            recyclerView.layoutManager = horizontalLinearLayoutManager
        }
        changeVerticalGridLayoutButton.setOnClickListener {
            recyclerView.layoutManager = verticalGridLayoutManager
        }
        changeHorizontalGridLayoutButton.setOnClickListener {
            recyclerView.layoutManager = horizontalGridLayoutManager
        }
        changeVerticalStaggeredGridLayoutButton.setOnClickListener {
            recyclerView.layoutManager = verticalStaggeredGridLayoutManager
        }
        changeHorizontalStaggeredGridLayoutButton.setOnClickListener {
            recyclerView.layoutManager = horizontalStaggeredGridLayoutManager
        }


    }
}

