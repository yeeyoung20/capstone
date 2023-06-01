package com.example.ecoproject_android
//위경도 db불러오는 코틀린
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream


class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, 1) {
    private val mDataBase: SQLiteDatabase? = null
    private val mContext: Context

    init {
        DB_PATH = "/data/data/" + context.packageName + "/databases/"
        mContext = context
        dataBaseCheck()
    }

    private fun dataBaseCheck() {
        val dbFile = File(DB_PATH + DB_NAME)
        if (!dbFile.exists()) {
            dbCopy()
            Log.d(TAG, "Database is copied.")
        }
    }

    @Synchronized
    override fun close() {
        mDataBase?.close()
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase) {
        // 테이블 구조 생성로직
        Log.d(TAG, "onCreate()")
    }

    override fun onOpen(db: SQLiteDatabase) {
        super.onOpen(db)
        //Toast.makeText(mContext,"onOpen()",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onOpen() : DB Opening!")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 테이블 삭제하고 onCreate() 다시 로드시킨다.
        Log.d(TAG, "onUpgrade() : DB Schema Modified and Excuting onCreate()")
    }

    // db를 assets에서 복사해온다.
    private fun dbCopy() {
        try {
            val folder = File(DB_PATH)
            if (!folder.exists()) {
                folder.mkdir()
            }
            val inputStream = mContext.assets.open(DB_NAME)
            val out_filename = DB_PATH + DB_NAME
            val outputStream: OutputStream = FileOutputStream(out_filename)
            val mBuffer = ByteArray(1024)
            var mLength: Int
            while (inputStream.read(mBuffer).also { mLength = it } > 0) {
                outputStream.write(mBuffer, 0, mLength)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("dbCopy", "IOException 발생함")
        }
    }

    companion object {
        private const val TAG = "DataBaseHelper" // Logcat에 출력할 태그이름

        // database 의 파일 경로
        private var DB_PATH = ""
        private const val DB_NAME = "LatLng.db"
    }
}