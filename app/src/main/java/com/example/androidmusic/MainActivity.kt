package com.example.androidmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private val musicManager: MusicManager = MusicManager(this@MainActivity)
    private var startFlag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startButton
        val strbtn: Button = findViewById(R.id.startbutton)

        // startButtonを押したときの処理を記述
        strbtn.setOnClickListener {
            if(!startFlag){
                musicManager.startMusic()
                startFlag = true
            }

        }

        //stopButton
        val stpbtn: Button = findViewById(R.id.stopbutton)

        // stopButtonを押したときの処理を記述
        stpbtn.setOnClickListener {
            if(startFlag){
                musicManager.stopMusic()
                startFlag = false
            }
        }

        // loopSwitch
        val loopswt: Switch = findViewById(R.id.loopswitch)

    }

    override fun onDestroy() {
        super.onDestroy()
        musicManager.stopMusic()
    }
}