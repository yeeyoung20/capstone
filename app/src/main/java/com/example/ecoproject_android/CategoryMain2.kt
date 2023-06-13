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

class CategoryMain2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView_Item_Adapter2
    private  var mList= ArrayList<RecyclerView_Item_Data2>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main2)

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
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images where name='TV' or name='공기청정기' or name='냉장고' or name='노트북' or name='노트북 배터리' or name='마우스' or name='멀티탭' or name='모니터' or name='보조배터리' or name='세탁기' or name='소형 난방기구' or name='스피커' or name='온수매트' or name='이어폰' or name='전기면도기' or name='전기장판' or name='전선' or name='충전기, 케이블' or name='컴퓨터' or name='키보드' or name='태블릿' or name='토너, 잉크 카트리지' or name='프린터' or name='하드디스크' ", null)

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

