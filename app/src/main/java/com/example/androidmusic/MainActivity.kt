package com.example.androidmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import com.example.androidmusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val musicManager: MusicManager = MusicManager(this@MainActivity)
    private var startFlag: Boolean = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.playImage.setOnClickListener {
            when(startFlag) {
                false -> {
                    musicManager.startMusic()
                    startFlag = true
                    binding.playImage.setImageResource(R.drawable.playbutton_300x300)
                }
                true -> {
                    musicManager.stopMusic()
                    startFlag = false
                    binding.playImage.setImageResource(R.drawable.posebutton_300x300)
                }
            }
        }

        // loopSwitch
        // val loopswt: Switch = findViewById(R.id.loopswitch)

    }

    override fun onDestroy() {
        super.onDestroy()
        musicManager.stopMusic()
    }
}