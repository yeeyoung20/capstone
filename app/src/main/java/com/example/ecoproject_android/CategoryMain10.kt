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

class CategoryMain10 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView_Item_Adapter2
    private  var mList= ArrayList<RecyclerView_Item_Data2>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main10)

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
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images where name='옷걸이' or name='가방' or name='레깅스' or name='모자' or name='속옷' or name='스타킹' or name='신발' or name='안경, 선글라스' or name='양말' or name='여행용 가방' or name='의류' or name='지갑' or name='한복' or name='주얼리'", null)

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

