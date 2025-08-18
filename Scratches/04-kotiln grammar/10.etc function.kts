
// 기타 기능

// 다음과 같은 기타 유용한 기능에 대해 간단히 살펴보자.
/*
 * 확장 함수 : 원래 이떤 클래스에 기능을 추가하는 함수
 * 형 변환 : 숫자형 자료형끼리 쉽게 형 변환 가능
 * 형 체크 : 변수의 형이 무엇인지 검사하는 기능
 * 고차 함수 : 인자로 함수를 전달하는 기능
 * 동반 객체 : 클래스의 인스턴스 생성 없이 사용할 수 있는 객체
 * let() 함수 : 블록에 자기 자신을 전달하고 수행된 결과를 반환하는 함수
 * with() 함수 : 인자로 객체를 받고 블록에서 수행된 결과를 반환하는 함수
 * apply() 함수 : 블록에 자기 자신을 전달하고 이 객체를 반환하는 함수
 * run() 함수 : 익명함수처럼 사용하거나, 블록에 자기 자신을 전달하고 수행된 결과를 반환하는 함수
 */

// 1. 확장 함수
// 코틀린은 확장 함수 기능을 사용하여 쉽게 기존 클래스에 함수를 추가할 수 있다.
// 확장 함수를 추가할 클래스에 점을 찍고 함수 이름을 작성한다.
// 확장 함수 내부에서는 이 객체를 this로 접근할 수 있고 이러한 객체를 리시버 객체라고 한다.
// 다음은 Int 자료형에서 짝수인지 아닌지를 알 수 있도록 isEven() 확장 함수를 추가한 예이다.
fun Int.isEven() = this % 2 == 0

val a = 5
val b = 6

println(a.isEven()) // false
println(b.isEven()) // true

// 자바에서는 기본 자료형에 기능을 추가하려면 상속을 받고 추가 메서드를 작성해야 했다.
// String 클래스의 경우는 final로 상속이 막혀 있어 이마저도 불가능했다.

// 2. 형 변환
// 숫자형 자료형끼리는 to자료형() 메서드를 사용하여 형 변환이 가능하다.
val c = 10L
val d = 20

val e = c.toInt() // Long을 Int로
val f = d.toDouble() // Int를 Double로
val g = c.toString() // Long을 String으로

// 숫자 형태의 문자열을 숫자로 바꿀 때는 자바와 마찬가지로 Integer.parseInt() 메서드를 사용한다.
val intStr = "10"
val int = Integer.parseInt(intStr)

// 일반 클래스 간에 형변환을 하려면 as 키워드를 사용한다.
open class Animal { }

class Dog : Animal()

val dog = Dog()

val animal = dog as Animal // dog를 Animal형으로 형 변환 (다형성)

// 3. 형 체크
// is 키워드를 사용하여 형을 체크할 수 있다. 자바의 instanceOf에 대응한다.
val str = "hello"

if (str is String) { // str이 String형이라면
    println(str.uppercase()) // toUpperCase() is deprecated.
}

// 4. 고차 함수
// 코틀린에서는 함수의 인수로 함수를 전달하거나 함수를 반환할 수 있다.
// 이렇게 다른 함수를 인수로 받거나 반환하는 함수를 고차 함수(higher-order function)라고 한다.

// 이 책에서 사용되는 예는 다음과 같다.
// add 함수는 x, y, callback 3개의 인수를 받는다.
// 내용은 callback에 x와 y의 합을 전달한다.
// 여기서 callback은 하나의 숫자를 받고 반환이 없는 함수이다.
// 자바에서는 주로 인터페이스를 사용하는데 코틀린은 함수를 활용하는 점이 다르다.

// 인수 : 숫자, 숫자, 하나의 숫자를 인수로 하는 반환값이 없는 함수(인수가 될 함수의 선언은 파라미터와 반환 타입만 선언한다)
fun add(x : Int, y : Int, callback : (sum : Int) -> Unit) {
    callback(x + y)
}

// 함수는 { }로 감싸고 내부에서는 반환값을 it로 접근할 수 있음
add(5, 3, { println(it) }) // 8

// 이러한 방식으로 구현된 예제를 자주 접하다 보면 자연스럽게 사용하고 있는 자신을 발견하게 된다.

// 5. 동반 객체
// 9장 예제에서 안드로이드 프래그먼트 컴포넌트를 다룰 때 자동으로 동반 객체 코드가 생성된다.
// 그 때 코드를 이해할 수 있도록 동반 객체를 간단히 알아보자.

// 프래그먼트는 특수한 제약 때문에 팩토리 메서드를 정의하여 인스턴스를 생성해야 한다.
// 팩토리 메서드는 생성자가 아닌 메서드를 사용해 객체를 생성하는 코딩 패턴을 말하는데 클래스와 별개로 보며 포함 관계도 아니다.
// 코틀린에서는 자바의 static과 같은 정적인 메서드를 만들 수 있는 키워드를 제공하지 않는다.
// 대신 동반 객체(companion object)로 이를 구현한다.

// 다음 코드는 newInstance() 정적 메서드를 사용하여 Fragment 객체를 생성하는 팩토리 패턴을 구현 및 사용하는 예이다.
class Fragment {
    companion object {
        fun newInstance() : Fragment {
            println("생성됨")
            return Fragment()
        }
    }
}

val fragment = Fragment.newInstance()

// 여기서 동반 객체 내부의 메서드는 Fragment 클래스와 아무 관계가 없는 정적인 존재이다.
// 이러한 패턴은 책의 9장에서 등장한다.

// 6. let() 함수
// 코틀린 기본 라이브러리는 몇 가지 유용한 함수를 제공한다.
// let() 함수는 블록에 자기 자신을 인수로 전달하고 수행된 결과를 반환한다.
// 인수로 전달한 객체는 it으로 참조한다.
// let() 함수는 인수가 1개이기 때문에 블록을 바깥으로 빼고, 괄호를 생략할 수 있다.
// let() 함수는 안전한 호출 연산자("?.")와 함께 사용하면 null값이 아닐 때만 실행하는 코드를 다음과 같이 나타낼 수 있다.
// fun <T, R> T.let(block : (T) -> R) : R

val intStr2 = "10"

// 괄호 안에 블록을 포함
val result = intStr2?.let({ // Int
    Integer.parseInt(it)
})

// 괄호 밖으로 블록을 뺌
//val result = intStr2?.let() { // Int
//    Integer.parseInt(it)
//}
//
//// 괄호를 생략함
//val result = intStr2?.let { // Int
//    Integer.parseInt(it)
//}

println(result) // 10

// 7. with() 함수
// with() 함수는 인수로 객체를 받고 블록에 리시버 객체로 전달한다. 그리고 수행된 결과를 반환한다.
// 리시버 객체로 전달된 객체는 this로 접근할 수 있다.
// 안전한 호출이 불가능하여 str이 null값이 아닌 경우에만 사용해야 한다.
// fun <T, R> with(receiver : T, block T.() -> R) : R

with(intStr2) {
    println(this.uppercase()) // 10
}

// this는 생략이 가능하므로 다음과 같이 작성할 수 있다.
val result2 = with(intStr2) {
    uppercase()
}

println(result2) // 10

// 8. apply() 함수
// apply() 함수는 블록에 객체 자신이 리시버 객체로 전달되고 이 객체가 반환된다.
// 객체의 상태를 변화시키고 그 객체를 다시 반환할 때 주로 사용한다.
// fun <T> T.apply(block : T.() -> Unit) : T
val result2 = car?.apply {
    this.setColor("BLUE")
    this.setPrice(2000)
}

// 9. run() 함수
// run() 함수는 익명 함수처럼 사용하는 방법과 객체에서 호출하는 방법을 모두 제공한다.
// 익명 함수처럼 사용할 때는 블록의 결과를 반환한다.
// 블록안에 선언된 변수는 모두 임시로 사용되는 변수이다.
// 아래 예시처럼 복잡한 계산에 임시변수가 많이 필요할 때 유용하다.
// fun <R> run(block : () -> R) : R
val avg = run {
    val korean = 100
    val english = 80
    val math = 60

    (korean + english + math) / 3.0
}

println(avg) // 80.0

// 객체에서 호출하는 방법은 객체를 블록의 리시버 객체로 전달하고 블록의 결과를 반환한다.
// 안전한 호출을 사용할 수 있어 with() 함수보다 더 유용하다.
// fun <T, R> T.run(block : T.() -> R) : R
val str100 = "hello"

str100?.run {
    println(uppercase()) // this 생략
}