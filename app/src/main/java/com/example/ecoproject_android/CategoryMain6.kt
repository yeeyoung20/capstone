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

class CategoryMain6 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView_Item_Adapter2
    private  var mList= ArrayList<RecyclerView_Item_Data2>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main6)

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
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images where name='화장품' or name='향수' or name='화장품(스틱)' or name='화장품(튜브)' or name='화장품(펌프형)' ", null)

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

