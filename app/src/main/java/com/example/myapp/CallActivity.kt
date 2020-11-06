package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        val back=findViewById<ImageView>(R.id.imgBack2)
        val textCall=findViewById<EditText>(R.id.edtCall_)
        val call=findViewById<ImageButton>(R.id.itnCall)

        back.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        call.setOnClickListener(View.OnClickListener {
            val c=textCall.text.toString()
            val callIntent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+c))
            startActivity(callIntent)
        })
    }
}