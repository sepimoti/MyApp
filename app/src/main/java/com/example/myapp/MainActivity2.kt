package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val back=findViewById<ImageView>(R.id.imgBack4)

        back.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DrawerActivity::class.java)
            startActivity(intent)
        })
    }
}