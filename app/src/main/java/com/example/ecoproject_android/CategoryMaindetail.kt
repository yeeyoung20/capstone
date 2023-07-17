package com.example.ecoproject_android

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryMaindetail : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var title: TextView
    private lateinit var adapter: CategoryMain_Adapter
    private  var mList= ArrayList<CategoryMain_Item_Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_maindetail)
        val back=findViewById<Button>(R.id.back)
        title=findViewById(R.id.title)

        getVal()//검색 아이템 추가


        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)

        adapter = CategoryMain_Adapter(mList)
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
        val categoryName = intent.getStringExtra("categoryname").toString()
        val cursor: Cursor = db.rawQuery("SELECT * FROM Images WHERE categoryname = '$categoryName'", null)
        title.setText(categoryName)


        while (cursor.moveToNext()) {
            val name= cursor.getString(0)
            val byteArray = cursor.getBlob(1)
            if (byteArray != null) {
                mList.add(CategoryMain_Item_Data(name, byteArray))
            }
        }

        cursor.close()
        dbHelper.close()
    }
}