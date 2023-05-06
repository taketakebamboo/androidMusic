package com.example.androidmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //stertButton
        val strbtn: Button = findViewById(R.id.startbutton)

        //stopButton
        val stpbtn: Button = findViewById(R.id.stopbutton)

        // loopSwitch
        val loopswt: Switch = findViewById(R.id.loopswitch)


    }
}