package com.chumak.testproject

import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val msg = "appProcess = ${Process.myPid()}"
        println(msg)
        Log.d("MainActivity", msg)
        findViewById<View>(R.id.button).setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                putExtra("URL", "https://www.google.com/");
            }.let(::startActivity)
        }
    }
}