package com.example.step14sqlite

import android.database.Cursor

class TodoDao(var helper:DBHelper) {
    //할일 정보를 저장하는 메소드
    fun insert(data:Todo){
        //java => SQLiteDataBase db=helper.getWritableDataBase()
        val db=helper.writableDatabase
        // ? 에 바인딩할 인자를 Any 배열로 얻어내기
        // java =>  Object[] args = { data.getContent() }
        val args = arrayOf<Any>(data.content)
        //실행할 sql 문
        // SQLiteDB => datetime('now','localtime') ,   oracle =>  SYSDATE
        val sql = "INSERT INTO todo (content, regdate)" +
                " VALUES(?, datetime('now','localtime'))"
        //sql 문 실행하기
        db.execSQL(sql, args)
        db.close() // close() 를 호출해야 실제로 반영된다.
    }
    //할일 목록을 리턴하는 함수
    fun getList():List<Todo>{
        //수정 가능한 Todo type 을 담을수 있는 List
        val list= mutableListOf<Todo>()
        //select 문을 수행해줄 객체
        val db=helper.readableDatabase
        //실행할 select 문 구성
        val sql="SELECT num, content, regdate FROM todo ORDER BY num ASC"
        //query 문을 수행하고 결과를 Cursor 객체로 얻어내기 (selection 인자는 없다)
        val result: Cursor = db.rawQuery(sql, null)

        //Cursor 객체의 메소드를 이용해서 담긴 내용을 반복문 돌면서 추출한다.
        while(result.moveToNext()){
            // 0 번째는 num, 1 번째는 content, 2 번째는 regdate 이다.
            val data=Todo(result.getInt(0), result.getString(1), result.getString(2))
            //할일 정보가 담긴 Todo 객체를 List 에 추가한다.
            list.add(data)
        }
        //할일 목록을 리턴해주기
        return list
    }
}