package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val back=findViewById<ImageView>(R.id.imgBackVideo)
        val VideoEdt=findViewById<EditText>(R.id.edtVideoView)
        val VideoBtn=findViewById<ImageButton>(R.id.btnVideoView)
        val VideoView=findViewById<VideoView>(R.id.videoView)

        back.setOnClickListener(View.OnClickListener {
            val intent= Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        VideoView.setMediaController(MediaController(this))
        VideoView.setVideoURI(Uri.parse("https://developer.android.com/studio/install"))
        VideoView.start()

        VideoBtn.setOnClickListener(View.OnClickListener {
            VideoView.setVideoURI(Uri.parse(VideoEdt.text.toString()))
            VideoView.start()
        })
    }
}