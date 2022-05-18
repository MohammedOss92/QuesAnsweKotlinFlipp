package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_first.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_first)

        btnQues.setOnClickListener{
            var i = Intent(this,SecondeActivity::class.java)
            startActivity(i)
        }

        btnRate.setOnClickListener {
//            Uri.parse("market://details?id com.example.myapplication")
            try {
                var uri = Uri.parse("market://details?id $packageName")
                var i = Intent(Intent.ACTION_VIEW)
                i.data = uri
                startActivity(i)
            }
            catch (ex:Exception){
                var uri = Uri.parse("http://play.google.com/store/apps/details?id $packageName")
                var i = Intent(Intent.ACTION_VIEW)
                i.data = uri
                startActivity(i)
            }
        }
    }
}
