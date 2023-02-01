package com.example.kotlin_test


class MyData{
    //문자열을 담을 필드
    var name:String?=null

    //인자로 전달받은 문자열을 필드에 저장하는 메소드
    fun putName(name:String){
        this.name=name
    }
}

fun main() {
    //val a : (Int) -> String = { num:Int -> "bye" }

    val nums:List<Int> = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
    val result:List<Int> = nums.filter { it % 2 == 0 }
    println(result)


    //8번
    val a1= MyData()
    a1.putName("hello")
    println(a1.name)
    println("-----------")


    //9번
    var a:String? = null
    var result1 = a ?: "hi"
    println(result1)
    println("-----------")


    //10번
    val  msgs = listOf<String>("eee", "ddd", "ccc", "bbb", "aaa")
    msgs.forEach{
        println(it)
    }
    println("-----------")
    for(i in msgs.reversed()){
        println(i)
    }
}