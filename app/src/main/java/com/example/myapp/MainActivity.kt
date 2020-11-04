package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
            val edtFirst=edtFirst.text.toString()
            val edtLast=edtLast.text.toString()
            val edtAge=edtAge.text.toString()
            val edtPhone=edtPhone.text.toString()
            val edtEmail=edtEmail.text.toString()

            val intent=Intent(this,ShowActivity::class.java)

            intent.putExtra("First",edtFirst)
            intent.putExtra("Last",edtLast)
            intent.putExtra("Age",edtAge)
            intent.putExtra("Phone",edtPhone)
            intent.putExtra("Email",edtEmail)

            startActivityForResult(intent,100)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100    &&   resultCode== Activity.RESULT_OK){
            val result=data?.getStringExtra("Comment")
            Toast.makeText(this,result, Toast.LENGTH_LONG).show()
        }
    }
}