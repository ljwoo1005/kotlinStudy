
// 코틀린에서 클래스의 생성자는 2가지가 있다.

// primary consturctor
// primary consturctor는 클래스 이름의 오른편에 위치합니다. 마치 함수의 파라미터 선언 방식과 비슷합니다.

class Person constructor(name : String) { }

// 만약 이 때 primary constructor가 애노테이션이나 접근 제한자를 갖지 않는다면 costructor 키워드를 생략할 수 있습니다.

class Person2(name : String) { }

// primary constructor에서는 어떠한 실행문도 포함될 수 없습니다.
// 만약 실행문으로 초기화하는 코드를 넣고 싶을 경우 클래스 내부에 init{} 블록을 사용합니다.

class Person3(name : String) {
    var personName : String

    init {
        this.personName = name
    }
}

// 위 코드에서 클래스 내부에 선언된 변수(var personName)는 프로퍼티(property)라고 불립니다. 자바에서 클래스의 인스턴스 변수와 유사합니다.
// 위 코드는 다음과 같이 함축할 수 있습니다.

class Person4(name : String) {
    var personName : String = name
}

// 그리고 이 코드 또한 한 줄로 압축할 수 있습니다.

class Person5(var personName : String) { }

// 클래스의 프로퍼티 초기화와 init 블록 실행은 같은 우선순위를 가집니다. 따라서 위에서부터 선언된 순서대로 수행됩니다.
// 위 코드를 자바로 변환하면 다음과 같습니다.

public class Person5 {
    public String personName;

    public Person5(String name) {
        this.personName = name;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String name) {
        this.personName = name
    }
}

// 코틀린의 클래스 프로퍼티는 선언 및 초기화 시 자동으로 getter와 setter가 생성됩니다. 이것이 자바의 인스턴스 변수와의 차이점입니다.
// 자바에서 여러 줄을 작성해야 하는 부분들이 코틀린에선 한 줄로 함축이 가능합니다.
// 만약 코틀린 클래스 프로퍼티를 val(상수)로 선언할 경우 setter는 생성되지 않습니다.

// 두 번째 생성자를 보기에 앞서 코틀린에서 클래스의 프로퍼티에 대해 자세히 알아보겠습니다.
// 자바스크립트의 프로퍼티를 사용하는 방법과 같습니다.

// getter
var person5 = Person5("JW")
println(person5.personName)

// setter
person5.personName = "LJW"
println(person5.personName)

// 프로퍼티의 getter/setter를 커스텀하여 사용할 수 있습니다.
// getter/setter를 커스텀할 때는 백킹 필드(backing field)라는 값을 사용하며, 이는 프로퍼티 값을 실제로 저장하는 공간입니다.

class Person55() {
    var personName : String = "LJW"
        get() {
            return field + "님"
        }
        set(name : String) {
            field = name
        }
}

var person55 = Person55()
println("person55 : " + person55.personName) // person55 : LJW님
person55.personName = "LJW2"
println("person55 after use setter : " + person55.personName) // person55 after use setter : LJW2님

// secondary constructor
// 코틀린의 두 번째 생성자입니다. 사용법은 클래스 내부에 constructor 블록을 작성합니다.

class Person6 {
    var personName : String

    constructor(otherPersonName : String) {
        this.personName = otherPersonName
    }
}

// 만약 클래스가 primary consturctor를 가지고 있을 경우, secondary constructor는 this() 생성자를 이용해 직간접적으로 primary constructor에 생성자를 위임해야 합니다.

class Person7(var personName : String) {
    var personAge : Int = 30

    constructor(name : String, age : Int) : this(name) {
        this.personAge = age
    }
}

// 위 코드에서 this()를 명시하지 않는다면 컴파일 에러가 발생합니다. Primary constructor call expected.

// 그렇다면 primary constructor, init블록, secondary constructor가 모두 존재한다면 실행 순서는 어떻게 될까요?

class Person8(var personName : String = "LJW") { // primary constructor에서 프로퍼티 선언 및 초기화 시 default 값을 정할 수 있습니다.
    var personAge : Int = 20

    init {
        println("primary constructor name : ${this.personName}")
        println("primary constructor age : ${this.personAge}")
    }

    constructor(name : String, age : Int, message : String) : this() {
        this.personName = name;
        this.personAge = age;

        println("secondary constructor name : ${this.personName}")
        println("secondary constructor age : ${this.personAge}")
        println("secondary constructor message : ${message}")
    }
}

var newPerson8 = Person8("LJW2", 30, "이몸 등장")

/* 결과
 * primary constructor name : LJW
 * primary constructor age : 20
 * secondary constructor name : LJW2
 * secondary constructor age : 30
 * secondary constructor message : 이몸 등장
 */
// 실행 순서는 primary constructor = init -> secondary constructor 순서대로 실행됩니다.
// 먼저 primary constructor와 init 블록이 위에서부터 순서대로 실행됩니다.
// personAge 프로퍼티는 선언과 동시에 20으로 초기화됩니다.(프로퍼티 선언이 생성자보다 우선)
// primary constructor 내부의 personName 프로퍼티는 선언과 동시에 "LJW" 값으로 초기화됩니다.
// init 블록이 실행되어 초기화된 personName과 personAge가 출력됩니다.
// secondary constructor를 통해 객체 생성 시 외부에서 전달받은 인자로 personName과 personAge의 값을 수정합니다.
// 그리고 personName, personAge 프로퍼티와 secondary constructor의 마지막 인자인 message 변수를 순서대로 출력합니다.

// 코틀린 클래스의 프로퍼티는 객체 생성시 반드시 초기화가 이루어져야 합니다.
// 자바에서 클래스의 멤버 변수는 default 초기화가 자동으로 진행되는 것과는 대비되는 모습입니다.

class Person9 {
    var personName : String // Property must be initialized or be abstract.
    var personAge : Int     // Property must be initialized or be abstract.
}

// 코틀린 클래스에는 static 키워드가 없지만, static 키워드를 사용하는 것과 유사하게 만드는 방법은 존재합니다.
// object 키워드, companion object 키워드 등을 사용합니다.
// 해당 내용은 추후에 보충하겠습니다.
