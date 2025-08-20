class Person3 {
    init {

    }

    constructor(name : String) {
        println(name)
    }

}


class Person4(var name : String) {
    init {
        println(name)
    }

    fun nameCall() {
        println(name)
    }
}

