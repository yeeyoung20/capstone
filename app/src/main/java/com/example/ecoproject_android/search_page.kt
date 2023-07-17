package com.example.ecoproject_android

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class search_page : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searvhView: SearchView
    private lateinit var back: Button
    private  var mList= ArrayList<search_Item_Data>()
    private lateinit var adapter: search_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_page)

        recyclerView = findViewById(R.id.RecyclerView)
        searvhView = findViewById(R.id.search)
        back=findViewById(R.id.back)
        back.setOnClickListener{finish()}

        // 검색 아이템관련 메소드?
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

        searvhView.isSubmitButtonEnabled = true//searchview 속성

        getVal()//검색 아이템 추가

        adapter = search_Adapter(mList)
        recyclerView.adapter=adapter

        //searchView 메소드
        searvhView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {//검색을 완료했을때 메소드 예: 이불
                recyclerView.visibility = View.GONE
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {//검색중일때 메소드 예:  이 >>이가 포함된 모든 아이템 나옴
                filterList(newText)//입력한 문자(newText) filterList에 보냄
                //if (newText == "")recyclerView.visibility = View.GONE
                return true
            }

        })

        //아이템 클릭 이벤트
        adapter.onItemClick = {
            val intent = Intent(this, CategoryDetail::class.java)
            val RecyclerView_Item_Data = it
            val title = RecyclerView_Item_Data?.title
            intent.putExtra("data", title)
            startActivity(intent)
        }
    }

    //받은 문자 newText를 검사해서 해당하는 글자 아이템을 보이게함
    private fun filterList(query : String?){
        if(query != null){
            recyclerView.visibility = View.VISIBLE
            val filteredList = ArrayList<search_Item_Data>()
            for (i in mList){
                if(i.title.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            adapter.setFilteredList(filteredList)

//            if(filteredList.isEmpty()){
//                Toast.makeText(this,"No Data found", Toast.LENGTH_SHORT).show()
//            }else{
//                adapter.setFilteredList(filteredList)
//            }
        }

    }

    open fun getVal() {
        val dbHelper = DataBaseHelper(this)
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images", null)

        while (cursor.moveToNext()) {
            val name= cursor.getString(0)
            val byteArray = cursor.getBlob(1)
            if (byteArray != null) {
                mList.add(search_Item_Data(name, byteArray))
            }
        }

        cursor.close()
        dbHelper.close()
    }

}