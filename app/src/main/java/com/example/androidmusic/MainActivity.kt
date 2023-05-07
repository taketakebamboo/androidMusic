package com.example.androidmusic

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.androidmusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val musicManager: MusicManager = MusicManager(this@MainActivity)
    private var startFlag: Boolean = false
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
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

        binding.seekBar.max = 150
        binding.seekBar.min = 0

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            // 値が変更された時に呼ばれる
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                val min: Int = progress / 60
                val sec: Int = progress % 60
                binding.musicSec.text = "$min".padStart(2,'0') + ":" + "$sec".padStart(2,'0')
            }

            // seekbarに触ったときで呼ばれる
            override fun onStartTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }

            // seekbarを離したとき呼ばれる
            override fun onStopTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        musicManager.stopMusic()
    }
}