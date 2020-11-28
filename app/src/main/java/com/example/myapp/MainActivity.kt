package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend=findViewById<ImageButton>(R.id.btnSend)
        val edtFirst=findViewById<EditText>(R.id.edtFirst)
        val edtLast=findViewById<EditText>(R.id.edtLast)
        val edtAge=findViewById<EditText>(R.id.edtAge)
        val edtPhone=findViewById<EditText>(R.id.edtPhone)
        val edtEmail=findViewById<EditText>(R.id.edtEmail)

        btnSend.setOnClickListener(View.OnClickListener {
            val dataFirst = edtFirst.text.toString()
            val dataLast = edtLast.text.toString()
            val dataAge = edtAge.text.toString().toInt()
            val dataPhone = edtPhone.text.toString().toInt()
            val dataEmail = edtEmail.text.toString()

            val DataBase=SQLiteHelper(this,"Data",null,1)
            DataBase.InsertData(dataFirst,dataLast,dataAge,dataPhone,dataEmail)
            Toast.makeText(this,"!!SAVED!!",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100    &&   resultCode==Activity.RESULT_OK){
            val result=data?.getStringExtra("Comment")
            Toast.makeText(this,result,Toast.LENGTH_LONG).show()
        }
    }*/
}