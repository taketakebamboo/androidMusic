package com.example.androidmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private val musicManager: MusicManager = MusicManager(this@MainActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //stertButton
        val strbtn: Button = findViewById(R.id.startbutton)

        // stertButtonを押したときの処理を記述
        strbtn.setOnClickListener {
            musicManager.stertMusic()
        }

        //stopButton
        val stpbtn: Button = findViewById(R.id.stopbutton)

        // stopButtonを押したときの処理を記述
        stpbtn.setOnClickListener {
            musicManager.stopMusic()
        }

        // loopSwitch
        val loopswt: Switch = findViewById(R.id.loopswitch)


    }
}