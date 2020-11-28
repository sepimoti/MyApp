package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import kotlin.random.Random

class PrayTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pray_time)
        val back=findViewById<ImageView>(R.id.imgBack5)

        val city=findViewById<EditText>(R.id.edtCity)
        val addCity=findViewById<ImageView>(R.id.itnAddCity)

        val morning=findViewById<TextView>(R.id.txtMorning)
        val sunrise=findViewById<TextView>(R.id.txtSunrise)
        val noon=findViewById<TextView>(R.id.txtNoon)
        val sunset=findViewById<TextView>(R.id.txtSunset)
        val night=findViewById<TextView>(R.id.txtNight)
        val midnight=findViewById<TextView>(R.id.txtMidnight)

        back.setOnClickListener(View.OnClickListener {
            val intent= Intent(this,DrawerActivity::class.java)
            startActivity(intent)
            finish()
        })

        addCity.setOnClickListener(View.OnClickListener {
            val CITY = city.text.toString()
            val client = AsyncHttpClient()
            val url: String ="http://api.aladhan.com/v1/timingsByCity?city=" + CITY + "&country=Iran&method=8"

            if (CITY.isNotEmpty()){
                client.get(url, object : JsonHttpResponseHandler() {
                    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                        super.onSuccess(statusCode, headers, response)
                        val gson = Gson()
                        val GetData = gson.fromJson(response.toString(), ServerAladhan::class.java)
                        println(GetData.data.timings.Asr)
                        morning.text = GetData.data.timings.Fajr.toString()
                        sunrise.text = GetData.data.timings.Sunrise.toString()
                        noon.text = GetData.data.timings.Dhuhr.toString()
                        sunset.text = GetData.data.timings.Sunset.toString()
                        night.text = GetData.data.timings.Maghrib.toString()
                        midnight.text = GetData.data.timings.Midnight.toString()
                    }

                    override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                        super.onFailure(statusCode, headers, throwable, errorResponse)
                        println(throwable?.message)
                    }
                })
            Toast.makeText(this, "!CHANGED!", Toast.LENGTH_SHORT).show()
            }

            else{
                Toast.makeText(this,"Please Enter the City",Toast.LENGTH_SHORT).show()
            }
        })
    }
}