
// 제어문은 크게 if, when, for, while 4가지로 나뉜다. when 문을 제외하고는 자바와 거의 같다.

// 1. if
// 실행할 문장이 한 줄이면 블록을 생략할 수 있다.
val a = 10
val b = 20

// 일반적인 방법
var max = a;
if(a < b) max = b

// if-else문의 사용법도 자바와 완전히 같다.
if(a < b) {
    max = a
} else {
    max = b
}

// 다음과 같이 if문을 식처럼 사용할 수도 있다.
val maxx = if(a > b) a else b

// 2. when
// when문은 자바의 switch문에 대응한다. when문을 사용하는 다양한 방법은 다음과 같다.
// 값이 하나인 경우는 물론 콤마(,)나 in 연산자로 값의 범위를 자유롭게 지정하는 것이 특징이다.
// 그 밖에 경우에는 else를 사용하여 나머지에 대한 경우를 처리한다(자바의 default에 대응)
// 코드를 작성할 때 블록으로 코드를 감쌀 수 있다.
val x = 1;

when(x) {
    1 -> println("x == 1")  // 값 하나
    2, 3 -> println("x == 2 or x == 3") // 여러 값은 콤마로
    in 4..7 -> println("4부터 7사이") // in 연산자로 범위 지정
    !in 8..10 -> println("8부터 10사이가 아님") // !연산자와 in 연산자를 합쳐 제외 범위 지정
    else -> {
        println("x는 1이나 2가 아님")
    }
}

// when문 역시 if문과 마찬가지로 식처럼 사용할 수 있다.
val number = 1

val numStr = when(number % 2) {
    0 -> "짝"
    1 -> println("")
    else -> "홀"
}

println(numStr) // kotlin.Unit -> 일부러 상수에 반환값을 지정하지 않고 반환타입이 Unit인 함수를 넣었는데 이렇게 나왔음

// when문의 결과를 함수의 반환값으로 사용할 수도 있다.
val number2 = 1

fun isEven(num : Int) = when(num % 2) {
    0 -> "짝"
    1 -> println("")
    else -> "홀"
} // 결과가 String으로 추론되어 반환형 선언 생략 가능

println( isEven(number2) ) // kotlin.Unit -> 일부러 상수에 반환값을 지정하지 않고 반환타입이 Unit인 함수를 넣었는데 이렇게 나왔음

// 3. for
// for문은 배열이나 컬렉션을 순회하는 문법으로 자바의 foreach문과 비슷하다.
// 다음은 1부터 5까지 담겨 있는 배열을 순회하며 모든 요소를 프린트하는 for문의 예시이다.
// in 키워드를 사용하여 모든 요소를 num 변수로 가져온다.
val numbers = arrayOf(1, 2, 3, 4, 5)

// for(num in numbers) -> for(int num : numbers)
for(num in numbers) {
    println(num)
}

// 그 밖에도 다음과 같이 다양한 사용 방법이 있다.
// 증가 범위는 ".." 연산자를 사용하며, 감소 범위는 downTo 키워드를 사용한다.
// step 키워드로 증감의 간격을 조절할 수 있다.

// 1~3까지 출력
// for(i in 1..3) -> for(int i=1; i<=3; i++)
for(i in 1..3) {
    println(i) // 1; 2; 3;
}

// 0~10까지 2씩 증가하며 출력
// for(i in 0..10 step 2) -> for(int i=0; i<=10; i+2)
for(i in 0..10 step 2) {
    println(i) // 0; 2; 4; 6; 8; 10;
}

// 10부터 0까지 2씩 감소하며 출력
// for(i in 10 downTo 0 step 2) -> for(int i=10; i<=0; i-2)
for(i in 10 downTo 0 step 2) {
    println(i) // 10; 8; 6; 4; 2; 0;
}

// 4. while
// while문은 주어진 조건이 참일 때 반복하는 문법이다.
// while문의 변형으로는 무조건 한 번은 실행되는 do-while문이 있다.
// 코틀린의 while문과 do-while문은 자바와 완전히 동일하다.
// 다음 두 코드는 동일한 결과를 낸다.

// while
var num1 = 10
while(num1 > 0) {
    num1--
    println(num1) // 9; 8; 7; 6; 5; 4; 3; 2; 1; 0;
}

// do-while
var num2 = 10;
do {
    num2--
    println(num2) // 9; 8; 7; 6; 5; 4; 3; 2; 1; 0;
} while(num2 > 0)
