
// 인터페이스는 미구현 메서드를 포함하여 클래스에서 이를 구현한다.
// 추상 클래스와 비슷하지만 클래스가 단일 상속만 되는 반면 인터페이스는 다중 구현이 가능하다.
// 주로 클래스에 동일한 속성을 부여해 같은 메서드라도 다른 행동을 할 수 있게 하는 데 사용한다.
// 코틀린의 인터페이스는 자바와 사용법이 거의 같다.

// 1. 인터페이스 선언
// 다음과 같이 인터페이스는 추상 메서드를 포함할 수 있다.
// 원래 추상 클래스에서 추상 메서드는 abstract 키워드가 필요한데 인터페이스에서는 생략할 수 있다.
interface Runnable {
    fun run()
}

// 인터페이스는 구현이 없는 메서드(추상 메서드)뿐만 아니라 구현된 메서드를 포함할 수 있다. 이는 자바8의 default 메서드에 대응한다.
interface Runnable2 {
    fun run()

    fun fastRun() = println("빨리 달린다")

    fun slowRun() {
        println("느리게 달린다")
    }
}

// 2. 인터페이스의 구현
// 인터페이스를 구현할 때는 인터페이스 이름을 콜론(":") 뒤에 나열한다.
// 그리고 미구현 메서드를 작성하는데 이 때 override 키워드를 메서드 앞에 추가한다.
// run 메서드를 오버라이드 한다고 말한다.
class Human : Runnable2 {
    override fun run() {
        println("달린다")
    }
}

val a = Human()
a.run() // 달린다
a.fastRun() // 빨리 달린다
a.slowRun() // 느리게 달린다

// 3. 상속과 인터페이스를 함께 구현
// 다음과 같이 상속과 인터페이스를 함께 구현할 수 있다.
// 상속은 하나의 클래스만 상속하는 반면 인터페이스는 콤마로 구분하여 여러 인터페이스를 동시에 구현할 수 있다.
open class Animal {

}

interface Runnable3 {
    fun run()

    fun fastRun() = println("빨리 달린다")
}

interface Eatable {
    fun eat()
}

class Dog : Animal(), Runnable3, Eatable {
    override fun eat() {
        println("먹는다")
    }

    override fun run() {
        println("달린다")
    }
}

val d = Dog()
d.eat() // 먹는다
d.run() // 달린다
d.fastRun() // 빨리 달린다

