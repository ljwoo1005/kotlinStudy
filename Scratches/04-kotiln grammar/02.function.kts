
// 함수(Funtion)는 일정 동작을 수행하는 특정 형식의 코드 뭉치를 의미한다.
// 함수는 자바에서 메서드에 해당한다.

// 함수를 선언하는 방식은 다음과 같다.
// fun 함수명(인수명 : 자료형1, 인수2명 : 자료형2, ...) : 반환자료형

// 다음은 하나의 문자열을 인수로 받고, println() 메서드로 출력하는 greet(I) 함수를 작성하고 사용하는 예시이다.
// 코틀린에서는 반환값이 없을 때 Unit형을 사용한다.
// Unit은 자바의 void에 대응한다.

fun greet(str : String) : Unit {
    println(str)
}

greet("123") // 123

// 반환값이 Unit일 때에는 다음과 같이 반환 자료형을 생략할 수 있다.

fun greet2(str : String) {
    println(str)
}

// 함수 표현식
// 코틀린은 자바스크립트와 같이 익명 함수를 통해 변수에 함수를 할당할 수 있다.
val function = fun(int : Int) : Int {
    println(int)
    return int
}

println(function) // 3; 3


// 자바와의 차이점
// 자바의 메서드 선언은 보통 접근제어자 반환타입 메서드명(파라미터 타입 파라미터명) {} 이런 방식으로 선언된다.
// Ex) public void greet(String str) { }
// 코틀린의 함수 선언은 fun키워드 함수명(파라미터명 : 파라미터 타입) : 반환타입 {} 이런 방식으로 선언된다.
// Ex) fun greet(str : String) : Unit { }