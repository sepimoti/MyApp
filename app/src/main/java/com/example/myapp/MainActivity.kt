package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSend=findViewById<ImageButton>(R.id.btnSend)
        val edtFirst=findViewById<EditText>(R.id.edtFirst)
        val edtLast=findViewById<EditText>(R.id.edtLast)
        val edtAge=findViewById<EditText>(R.id.edtAge)
        val edtPhone=findViewById<EditText>(R.id.edtPhone)
        val edtEmail=findViewById<EditText>(R.id.edtEmail)

        btnSend.setOnClickListener(View.OnClickListener {
            val dataFirst=edtFirst.text.toString()
            val dataLast=edtLast.text.toString()
            val dataAge=edtAge.text.toString()
            val dataPhone=edtPhone.text.toString()
            val dataEmail=edtEmail.text.toString()

            val intent=Intent(this,DrawerActivity::class.java)

            val prefFirst=PreferenceManager.getDefaultSharedPreferences(this).edit().putString("first",dataFirst).apply()
            val prefLast=PreferenceManager.getDefaultSharedPreferences(this).edit().putString("last",dataLast).apply()
            val prefAge=PreferenceManager.getDefaultSharedPreferences(this).edit().putString("age",dataAge).apply()
            val prefPhone=PreferenceManager.getDefaultSharedPreferences(this).edit().putString("phone",dataPhone).apply()
            val prefEmail=PreferenceManager.getDefaultSharedPreferences(this).edit().putString("email",dataEmail).apply()

            startActivity(intent)
/*            intent.putExtra("First",dataFirst)
            intent.putExtra("Last",dataLast)
            intent.putExtra("Age",dataAge)
            intent.putExtra("Phone",dataPhone)
            intent.putExtra("Email",dataEmail)

            startActivityForResult(intent,100)*/
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100    &&   resultCode==Activity.RESULT_OK){
            val result=data?.getStringExtra("Comment")
            Toast.makeText(this,result,Toast.LENGTH_LONG).show()
        }
    }
}