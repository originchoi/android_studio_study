package com.example.kotlin_test

//1.번 문제
open class Book{
    fun call(){
        println("전화를 걸어요")
    }
}
// Book 클래스를 상속받은 MyBook 클래스
class MyBook:Book(){
    fun call2(){
        println("전화를 걸어요2")
    }
}

//2번 문제
abstract class Test{
    abstract fun go()
}

abstract class Weapon{
    fun move(){
        println("이동 합니다.")
    }
    abstract fun attack()
}


//3번 문제
class Bird{
    companion object{
        fun sing(){
            println("노래해요!")
        }
    }
}
//fun main() {
//    //Bird 클래스의 sing() 메소드를 호출하려면 여기를 어떻게 코딩해야 하는가?
//
//}






fun main(){
    val p1= Book()
    val p2= MyBook()
    p2.call()
    println("---------------")
    Bird.sing()
    println("---------------")

    //4번문제
    val profile= mutableMapOf<String, Any>()
    profile.put("id", "kim")
    profile.put("pwd", "1234")
    profile.put("address", "seoul")

    println(profile)
}