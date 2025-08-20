
// 컬렉션
// 컬렉션은 개발에 유용한 자료구조를 말한다. 안드로이드 개발에서도 리스트나 맵은 자주 사용되는 자료구조이다.

// 1. 리스트
// 리스트는 배열처럼 같은 자료형의 데이터들을 순서대로 가지고 있는 자료구조이다.
// 중복된 아이템을 가질 수 있고 추가, 삭제, 교체 등이 쉽다.

// 요소를 변경할 수 없는 읽기 전용 리스트는 listOf() 메서드로 작성할 수 있다.
val foods : List<String> = listOf("라면", "갈비", "밥")

// 형 추론으로 자료형을 생략할 수 있다.
val foods2 = listOf("라면", "갈비", "밥")

// 요소를 변경하는 리스트를 작성할 때는 mutableListOf() 메서드를 사용한다.
// 자바와 다른 점은 특정 요소에 접근할 때 대괄호 안에 요소 번호로 접근할 수 있다는 것이다.(배열처럼)
// 자바 : list.get(1) | 코틀린 : list[1]
val foods3 = mutableListOf("라면", "갈비", "밥")

foods3.add("초밥") // 초밥을 맨 뒤에 추가 - ["라면", "갈비", "밥", "초밥"]
foods3.removeAt(0) // 맨 앞의 아이템 삭제 - ["갈비", "밥", "초밥"]
foods3[1] = "부대찌개" // foods3.set(1, "부대찌개") - 1번째 아이템을 부대찌개로 변경 - ["갈비", "부대찌개", "초밥"]

println(foods3) // [갈비, 부대찌개, 초밥]
println(foods3[0]) // 갈비

// 2. 맵
// 맵은 Key와 Value의 쌍으로 이루어져있는 자료구조이다. Key는 중복될 수 없다.
// 리스트와 마찬가지로 mapOf() 메서드로 읽기 전용 맵을 만들 수 있고, mutableMapOf() 메서드로 수정 가능한 맵을 만들 수 있다.
// 맵의 요소에 접근할 때는 대괄호 안에 Key를 요소명으로 작성하여 접근한다.
// 자바 : map.get("key") | 코틀린 : map["key"]

// 읽기 전용 맵
// Map<String, Any> -> 자바의 Map<String, Object>
val map : Map<String, Any> = mapOf("a" to 1, "b" to 2, "c" to 3)

// 변경 가능한 맵
val citiesMap = mutableMapOf("한국" to "서울", "일본" to "동경", "중국" to "북경")

// 요소에 덮어쓰기
citiesMap["한국"] = "서울특별시" // citiesMap.put("한국", "서울특별시")

// 추가
citiesMap["미국"] = "워싱턴" // citiesMap.put("미국", "워싱턴")

// 삭제
citiesMap.remove("일본")  // citiesMap.remove("일본")

// 맵 전체의 키와 값을 탐색할 때는 다음과 같이 간단히 탐색할 수 있다.
// 맵의 키와 값을 탐색
for ( (key, value) in map ) { // 마치 자바스크립트와 같은 모습
    println("$key -> $value")
}

// 3. 집합(Set)
// 집합(Set)은 중복되지 않는 요소들로 구성된 자료구조이다.
// setOf() 메서드로 읽기 전용 집합을, mutableSetOf() 메서드로 수정 가능한 집합을 생성한다.
// 집합은 이 책의 예제에서는 사용하지 않지만 리스트, 맵과 함께 대표적인 기본 자료구조이다.

// 읽기 전용 집합
val citySet : Set<String> = setOf("서울", "수원", "부산")

// 수정 가능한 집합
val citySet2 = mutableSetOf("서울", "수원", "부산")
citySet2.add("안양") // [서울, 수원, 부산, 안양]
citySet2.remove("수원") // [서울, 부산, 안양]

// 집합의 크기
println(citySet2.size) // 3
// "서울"이 집합에 포함되는지 여부
println(citySet2.contains("서울")) // true
