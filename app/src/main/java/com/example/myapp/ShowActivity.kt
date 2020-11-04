package com.example.myapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val txtName=findViewById<TextView>(R.id.txtName)
        val txtEmailShow=findViewById<TextView>(R.id.txtEmailShow)
        val txtPhoneShow=findViewById<TextView>(R.id.txtPhoneShow)
        val txtAgeShow=findViewById<TextView>(R.id.txtAgeShow)
        val edtComment=findViewById<EditText>(R.id.edtComment)
        val btnOk=findViewById<ImageButton>(R.id.btnOk)

        val intent=intent
        val get1=intent.getStringExtra("First")
        val get2=intent.getStringExtra("Last")
        val get3=intent.getStringExtra("Age")
        val get4=intent.getStringExtra("Phone")
        val get5=intent.getStringExtra("Email")

        txtName.text=get1+" "+get2
        txtAgeShow.text=get3
        txtPhoneShow.text=get4
        txtEmailShow.text=get5

        btnOk.setOnClickListener(View.OnClickListener {
            val edtComment=edtComment.text.toString()
            intent.putExtra("Comment",edtComment)
            setResult(Activity.RESULT_OK,intent)
            finish()
        })
    }
}