package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        val firstName=findViewById<TextView>(R.id.txtFistName)
        val lastName=findViewById<TextView>(R.id.txtLastName)

        val recycler=findViewById<RecyclerView>(R.id.recycler)
        val recycler2=findViewById<RecyclerView>(R.id.recycler2)
        val list=generateList(25)
        val adapter=RecyclerViewAdapter(list)

        val imgHome=findViewById<ImageView>(R.id.imgHome)
        val drawer=findViewById<DrawerLayout>(R.id.drawer)

        val profile=findViewById<TextView>(R.id.txtProfile)
        val picture=findViewById<TextView>(R.id.txtPicture)
        val call=findViewById<TextView>(R.id.txtCall)
        val sms=findViewById<TextView>(R.id.txtSms)

        firstName.text=intent.getStringExtra("First")
        lastName.text=intent.getStringExtra("Last")

        recycler.adapter=adapter
        recycler.layoutManager=LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        recycler.setHasFixedSize(true)
        recycler2.adapter=adapter
        recycler2.layoutManager=LinearLayoutManager(this,RecyclerView.HORIZONTAL,true)
        recycler2.setHasFixedSize(true)

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

    fun generateList(size : Int) : List<ElementItem> {
        val myList = ArrayList<ElementItem>()
            for (i in 0 until size) {
                val img = when (i % 4) {
                    0 -> R.drawable.drafts
                    1 -> R.drawable.language
                    2 -> R.drawable.personal_video
                    3 -> R.drawable.train
                    else -> R.drawable.ic_launcher_background
                }
                var j=i+1
                val title="Item $j"
                val desc=when(i % 3){
                    0 -> "Hello"
                    1 -> "Congratulation"
                    2 -> "Well Done"
                    else -> "UNKNOWN"
                }
                val items=ElementItem(img , title , desc)
                myList+=items
            }
        return myList
        }
}