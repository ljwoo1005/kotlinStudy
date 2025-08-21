
// null 가능성
// 코틀린에서는 기본적으로 객체를 불변으로 보고 null값을 허용하지 않는다.
// null값을 허용하려면 별도의 연산자가 필요하고 null을 허용한 자료형을 사용할 때도 별도의 연산자들을 사용하여 안전하게 호출해야 한다.

// 1. null 허용?
// 코틀린에서는 기본적으로 null값을 허용하지 않는다.
// 따라서 모든 객체는 생성과 동시에 값을 대입하여 초기화해야 한다.

// 다음 코드는 초기화하지 않아 에러가 발생한다.
val a : String // 에러 : 반드시 초기화를 해야 함

// 다음 코드는 null값으로 초기화해서 에러가 발생한다.
val b : String = null // 에러 : 코틀린은 기본적으로 null값을 허용하지 않음

// 코틀린에서 null을 허용하려면 자료형의 오른쪽에 ("?") 기호를 붙여주면 된다.
// 다음 코드는 null값을 허용하는 String 객체이기 때문에 에러가 발생하지 않는다.
val c : String? = null // OK

// 자바에서는 int, long, double과 같은 primitive type은 null값을 허용하지 않지만, 그외 모든 클래스형 변수는 null값을 허용한다.

// 2. lateinit 키워드로 늦은 초기화
// 안드로이드를 개발할 때는 초기화를 나중에 할 경우가 있다. 이 때는 lateinit 키워드를 변수 선언 앞에 추가하면 된다.
// 안드로이드에서는 특정 타이밍에 객체를 초기화할 때 사용한다.
// 초기화를 잊는다면 잘못된 null값을 참조하여 앱이 종료될 수 있으니 주의해야 한다.
lateinit var d : String // OK

d = "hello" // 늦은 초기화
println(d) // hello

// lateinit은 다음 조건에서만 사용할 수 있다.
/*
 * var 키워드(변수)에서만 사용한다.
 * null값으로 초기화할 수 없다.
 * 초기화 전에는 변수를 사용할 수 없다.
 * Int, Long, Double, Float에서는 사용할 수 없다.
 */

// 3. lazy로 늦은 초기화
// lateinit이 var로 선언한 변수의 늦은 초기화라면 lazy는 값을 변경할 수 없는 val을 사용할 수 있다.
// val 선언 뒤에 by lazy 블록에 초기화에 필요한 코드를 작성한다.
// 마지막 줄에는 초기화할 값을 작성한다.
// 아래에 str이 처음 호출될 때 초기화 블록의 코드가 실행된다.
// println() 메서드로 두 번 호출하면 처음에만 "초기화"가 출력된다.
val str : String by lazy {
    println("초기화") // 초기화에 필요한 코드
    "hello" // 초기화할 값
}

println(str) // 초기화; hello
println(str) // hello

// lazy로 늦은 초기화를 하면 앱이 시작될 때 연산을 분산시킬 수 있어 빠른 실행에 도움이 된다.
// lazy는 다음 조건에서만 사용할 수 있다.
/*
 * val 키워드(상수)에서만 사용한다.
 */

// 4. null값이 아님을 보증(!!)
// 변수 뒤에 ("!!")를 추가하면 null값이 아님을 보증하게 된다.
// 다음과 같이 null값이 허용되는 name 변수의 경우 String? 타입이기 때문에 String 타입으로 변환하려면 !!를 붙여서 null값이 아님을 보증해야 한다.
val name : String? = "키다리"

val name2 : String = name // 에러
val name3 : String? = name // OK

val name4 : String = name!! // OK

// 5. 안전한 호출(?.)
// 메서드 호출 시 점(".") 연산자 대신 ("?.") 연산자를 사용하면 null 값이 아닌 경우에만 호출된다.
// 다음 코드는 str2 변수의 값이 null값이 아니라면 대문자로 변경하고, null값이라면 null을 반환한다.
val str2 : String? = null

var ifUpperCase = if (str2 != null) str2 else null // null
var safeCallUpperCase = str2?.toUpperCase() // null

// 안전한 호출을 사용하면 복잡한 if문을 한 줄로 줄일 수 있다.

// 6. 엘비스 연산자(?:)
// 안전한 호출 시 null이 아닌 기본값을 반환하고 싶을 때는 엘비스 연산자를 함께 사용한다.
// 마지막 코드는 이제 null이 아닌 "초기화하시오"라는 문자열을 반환한다.
val str3 : String? = null

var ifUpperCase2 = if (str3 != null) str else null // null
var safeCallUpperCase = str3?.toUpperCase() ?: "초기화하시오" // 초기화하시오

