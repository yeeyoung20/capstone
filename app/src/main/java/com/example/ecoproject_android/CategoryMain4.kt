package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryMain4 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView_Item_Adapter2
    private  var mList= ArrayList<RecyclerView_Item_Data2>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main4)

        val back=findViewById<Button>(R.id.back)

        getVal()//검색 아이템 추가


        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)

        adapter = RecyclerView_Item_Adapter2(mList)
        recyclerView.adapter=adapter

        //뒤로가기
        back.setOnClickListener{finish()}


        adapter.onItemClick = {
            val intent = Intent(this, CategoryDetail::class.java)
            val RecyclerView_Item_Data = it
            val title = RecyclerView_Item_Data?.title
            intent.putExtra("data", title)
            startActivity(intent)
        }
    }
    open fun getVal() {
        val dbHelper = DataBaseHelper(this)
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images where name='치약' or name='규조토 매트' or name='두루마리 휴지' or name='브리타 정수기 필터' or name='수건' or name='총소 솔' or name='칫솔' or name='펌프형 용기' ", null)

        while (cursor.moveToNext()) {
            val name= cursor.getString(0)
            val byteArray = cursor.getBlob(1)
            if (byteArray != null) {
                mList.add(RecyclerView_Item_Data2(name, byteArray))
            }
        }

        cursor.close()
        dbHelper.close()
    }
}

