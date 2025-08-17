
// 코틀린에서 클래스의 역할은 자바와 유사하지만 더 간결하다.

// 1. 클래스 선언
class Person {

}

// 인스턴스 생성
// 자바에서는 new 키워드로 객체를 생성하지만 코틀린에서는 new 키워드를 사용하지 않는다.
val person = Person()

// 2. 생성자
// 생성자를 가지는 클래스는 다음과 같이 표현할 수 있다.
// 이 코드는 빈 생성자를 가지는 클래스이다.
class Person2(var name : String) {

}

// 생성자에서 초기화 코드를 작성하려면 다음과 같이 constructor로 생성자를 표현하고 블록에 코드를 작성한다.
// 이 생성자는 name을 출력한다.
class Person3 {
    constructor(name : String) {
        println(name)
    }
}

// 코틀린에서는 생성자 이외에도 init 블록에 작성한 코드가 클래스를 인스턴스화할 때 가장 먼저 초기화된다.
// 즉, 위의 코드를 다음과 같이 작성할 수 있다.
class Person4(var name : String) {
    init {
        println(name)
    }
}

// 3. 프로퍼티

// 클래스의 속성을 사용할 때는 멤버에 직접 접근하며 이를 프로퍼티라 한다.
// 다음 코드에서 Person 클래스는 name 프로퍼티를 가지고 있다.
// 프로퍼티에 값을 쓰려면 = 기호로 값을 대입한다. 값을 읽을 때는 프로퍼티를 참조한다.
// 코틀린에서는 다음과 같이 사용한다. 속성에 값을 설정하거나 얻으려면 getter/setter 메서드 없이 바로 점을 찍고 name 프로퍼티에 접근할 수 있다.
// 마치 자바스크립트와 유사한 사용방법. 하지만 자바스크립트와는 다르게 없는 프로퍼티를 get, set하려하면 컴파일 에러가 발생한다.

// 클래스 선언
class Person5(var name : String) {

}

// 인스턴스 생성
val person5 = Person5("멋쟁이")
person5.name = "키다리" // setter
println(person5.name) // getter

// 자바로 작성된 클래스의 getter/setter 메서드는 코틀린에서 사용할 때 기존의 getter/setter르 사용할 수도 있고 프로퍼티로 사용할 수도 있다.
// 이 책의 예제에서는 가급적이면 프로퍼티로 사용한다.

// 자바에서의 클래스
class JavaPerson {
    private String name;

    public JavaPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 4. 접근 제한자
// 접근 제한자란 변수나 함수를 공개하는 데 사용되는 키워드이다.
/*
 * public(생략 가능) : 프로젝트 내부에서 전체 공개이다. 아무것도 쓰지 않으면 기본적으로 public이다.
 * private : 현재 파일 내부에서만 사용할 수 있다.
 * internal : 같은 모듈 내에서만 사용할 수 있다. 코틀린에서 모듈은 프로젝트의 바로 아래의 개념이며 클래스와 패키지를 포함한다.
 * protected : 상속받은 클래스에서만 사용할 수 있다. 자바와 다르게 같은 패키지에 위치한 관계이더라도 상속받지 않으면 사용할 수 없다. 파일 최상단은 클래스가 아니기 때문에 사용할 수 없다.
 */
class A {
    val a = 1 // public
    private val b = 2
    protected val c = 3
    internal val d = 4
}

// 안드로이드 스튜디오의 프로젝트는 app 모듈을 기본 제공해 여기서 앱을 개발한다.
// 이 책에서는 기본 app 모듈만 사용하지만 사실 여러 모듈을 생성할 수 있다.
// 예를 들어 같은 프로젝트에 스마트폰용, 시계용, TV용 안드로이드 앱을 만든다면 모듈 3개를 생성한다.
// internal은 이 모듈 간 접근을 제한하는 키워드이다.

// 5. 클래스 상속
// 코틀린에서의 클래스는 기본적으로 상속이 금지된다.
// 상속이 가능하게 하려면 open 키워드를 클래스 선언 앞에 추가한다.
// 다음은 Animal 클래스를 상속받는 Dog 클래스를 나타낸다.
open class Animal {

}

class Dog : Animal() {

}

// 만약 상속받을 클래스가 생성자를 가지고 있다면 다음과 같이 상속받을 수 있다.
open class Animal2(val name : String) {

}

// 하위 클래스의 이름 옆에 함수의 파라미터를 선언하는 것 처럼 상위 클래스의 프로퍼티를 작성한다.
class Dog2(name : String) : Animal2(name) {

}

// 6. 내부 클래스
// 내부 클래스 선언에는 inner 키워드를 사용한다.
// 내부 클래스는 외부 클래스에 대한 참조를 가지고 있다.
// 아래 코드에서 inner 키워드가 없다면 a를 20으로 변경할 수 없다.
class OuterClass {
    var a = 10

    // 내부 클래스
    inner class OuterClass2 {
        fun something() {
            a = 20 // 외부 클래스의 프로퍼티에 접근 가능
        }
    }
}

// 7. 추상 클래스
// 추상 클래스는 미구현 메서드가 포함된 클래스를 말한다.
// 클래스와 미구현 메서드 앞에 abstract 키워드를 붙인다.
// 추상 클래스는 직접 인스턴스화할 수 없고 다른 클래스가 상속하여 미구현 메서드를 구현해야 한다.
// 기본적으로 자바와 동일한 특성을 가진다.
abstract class AbstractClass {
    abstract fun func()

    fun func2() {
        println("hello")
    }
}

class CompleteClass : AbstractClass() {
    // 코틀린에서는 오버라이딩할 때 @Override 애노테이션이 아닌 override 키워드를 사용한다.
    override fun func() {
        func2()
    }
}

val a = AbstractClass() // 에러
val a = CompleteClass() // OK
a.func() // hello