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

class CategoryMain11 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView_Item_Adapter2
    private  var mList= ArrayList<RecyclerView_Item_Data2>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main11)

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
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images where name='영수증' or name='고무' or name='깨진 유리' or name='비닐류 OTHER' or name='신용카드' or name='재활용 불가 플라스틱' or name='전단지' or name='타지 않는 쓰레기' or name='플라스틱 OTHER' or name='혼합종이'", null)

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

