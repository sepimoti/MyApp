package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_url)
        val Isha=findViewById<TextView>(R.id.txtIsha)
        Thread(Runnable {
            try{
                val url=URL("http://api.aladhan.com/v1/timingsByCity?city=Tehran&country=Iran&method=8")
                var con=url.openConnection() as HttpURLConnection
                con.requestMethod="GET"
                con.setRequestProperty("User-Agent","Mozilla/5.0")
                val requestCode=con.responseCode
                if(requestCode == HttpURLConnection.HTTP_OK){
                    val reader=BufferedReader(InputStreamReader(con.inputStream))
                    var line :String?
                    val responce=StringBuffer()
                    while (reader.readLine().also { line=it } != null){
                        responce.append(line)
                    }
                    val objec1=JSONObject(responce.toString())
                    val result1=objec1.getString("data")
                    val object2=JSONObject(result1.toString())
                    val result2=object2.getString("timings")
                    val object3=JSONObject(result2.toString())
                    val result3=object3.getString("Sunset")
                    println(result3)
                }

            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }).start()
    }
}