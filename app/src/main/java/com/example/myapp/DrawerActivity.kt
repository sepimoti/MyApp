package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class DrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val imgHome=findViewById<ImageView>(R.id.imgHome)
        val drawer=findViewById<DrawerLayout>(R.id.drawer)
        val firstName=findViewById<TextView>(R.id.txtFistName)
        val lastName=findViewById<TextView>(R.id.txtLastName)
        val profile=findViewById<TextView>(R.id.txtProfile)
        val picture=findViewById<TextView>(R.id.txtPicture)
        val call=findViewById<TextView>(R.id.txtCall)
        val sms=findViewById<TextView>(R.id.txtSms)

        firstName.text=intent.getStringExtra("First")
        lastName.text=intent.getStringExtra("Last")

        imgHome.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.START)
        })

        profile.setOnClickListener(View.OnClickListener {
            val intentProfile=Intent(this,MainActivity::class.java)
            startActivity(intentProfile)
            finish()
        })

        picture.setOnClickListener(View.OnClickListener {
            val intentPicture=Intent(this,PictureActivity::class.java)
            startActivity(intentPicture)
            finish()
        })

        call.setOnClickListener(View.OnClickListener {
            val intentCall=Intent(this,CallActivity::class.java)
            startActivity(intentCall)
            finish()
        })

        sms.setOnClickListener(View.OnClickListener {
            val intentSms=Intent(this,SmsActivity::class.java)
            startActivity(intentSms)
            finish()
        })
    }
}