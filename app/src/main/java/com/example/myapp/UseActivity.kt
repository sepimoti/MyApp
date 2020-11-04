package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class UseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use)
        val edtSite=findViewById<EditText>(R.id.edtSite)
        val btnBrowse=findViewById<ImageButton>(R.id.btnBrowse)
        val edtCall=findViewById<EditText>(R.id.edtCall)
        val btnCall=findViewById<ImageButton>(R.id.btnCall)
        val edtSms=findViewById<EditText>(R.id.edtSms)
        val edtTextSms=findViewById<EditText>(R.id.edtTextSms)
        val btnSms=findViewById<ImageButton>(R.id.btnSms)
        val btnCamera=findViewById<ImageButton>(R.id.btnCamera)

        btnBrowse.setOnClickListener(View.OnClickListener {
            val edtSite=edtSite.text.toString()
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://"+edtSite))
            startActivity(intent)
        })

        btnCall.setOnClickListener(View.OnClickListener {
            val edtCall=edtCall.text.toString()
            val intentCall=Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + edtCall))
            startActivity(intentCall)
        })

        btnSms.setOnClickListener(View.OnClickListener {
            val edtSms=edtSms.text.toString()
            val edtTextSms=edtTextSms.text.toString()
            val intentSms=Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + edtSms))
            intentSms.putExtra("sms_body",edtTextSms)
            startActivity(intentSms)
        })

        btnCamera.setOnClickListener(View.OnClickListener {
            val intentCamera=Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentCamera,200)
        })
    }
}