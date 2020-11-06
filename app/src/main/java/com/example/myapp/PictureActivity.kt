package com.example.myapp

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class PictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        val back=findViewById<ImageView>(R.id.imgBack)
        val camera=findViewById<ImageButton>(R.id.itnCamera)

        back.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        camera.setOnClickListener(View.OnClickListener {
            val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent,50)
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val picture=findViewById<ImageView>(R.id.imgPicture)
        if (requestCode == 50 && resultCode== Activity.RESULT_OK) {
            val image = (data?.extras?.get("data") as Bitmap)
            picture.setImageBitmap(image)
        }
    }
}