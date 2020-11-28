package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val back=findViewById<ImageView>(R.id.imgBackWeb)
        val WebEdt=findViewById<EditText>(R.id.edtWebView)
        val WebBtn=findViewById<Button>(R.id.btnWebView)
        val WebView=findViewById<WebView>(R.id.webView)

        back.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        WebView.settings.javaScriptEnabled=true
        WebView.settings.setSupportZoom(true)
        WebView.webViewClient= WebViewClient()
        WebView.loadUrl("https://www.google.com")

        WebBtn.setOnClickListener(View.OnClickListener {
            WebView.loadUrl("http://"+WebEdt.text.toString())
        })
    }
}