package com.example.myapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLiteHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    val Table_Name="Data"

    override fun onCreate(db: SQLiteDatabase?) {
        val Create_Table=("CREATE TABLE " + Table_Name
                               +" (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                               +"name TEXT,"
                               +"family TEXT,"
                               +"age INTEGER,"
                               +"phone INTEGER,"
                               +"email TEXT)")
        db?.execSQL(Create_Table)
    }

    fun InsertData(name : String , family : String , age : Int , phone : Int , email : String){
        val Insert_Table=("INSERT INTO " + Table_Name + " (name,family,age,phone,email) VALUES "
                               + "('" + name + "','" + family + "'," + age + "," + phone + ",'" + email + "')" )
        val db=this.writableDatabase
        db.execSQL(Insert_Table)
        db.close()
    }

    fun ReadTable(selector : String) : String{
        val Read_Table="SELECT DISTINCT "+selector+" FROM "+Table_Name
        var result=""
        val db=this.readableDatabase
        val data:Cursor=db.rawQuery(Read_Table,null)
        while (data.moveToNext()) {
            result+=result+data.getString(0)+"\n"
        }
        return result
        }

    fun DeleteTable(name : String){
        val Delete_Table="DELETE FROM "+Table_Name+" WHERE name LIKE '%"+name+"%'"
        val db=this.writableDatabase
        db.execSQL(Delete_Table)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}