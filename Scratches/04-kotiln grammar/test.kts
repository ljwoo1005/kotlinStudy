val citySet : Set<String> = setOf("서울", "수원", "부산")

val citySet2 = mutableSetOf("서울", "수원", "부산")
citySet2.add("안양")  // [서울, 수원, 부산, 안양]
citySet2.remove("수원") // [서울, 부산, 안양]

println(citySet2.size) // 3

println(citySet2.contains("서울")) // true



