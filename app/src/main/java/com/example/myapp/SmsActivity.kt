package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class SmsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        val back=findViewById<ImageView>(R.id.imgBack3)
        val smsNum=findViewById<EditText>(R.id.edtSMS)
        val smsText=findViewById<EditText>(R.id.edtTextSMS)
        val smsBtn=findViewById<ImageButton>(R.id.btnSMS)

        back.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        smsBtn.setOnClickListener(View.OnClickListener {
            val sms=smsNum.text.toString()
            val SMS=smsText.text.toString()
            val intentSms=Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+sms))
            intentSms.putExtra("sms_body",SMS)
            startActivity(intentSms)
        })
    }
}