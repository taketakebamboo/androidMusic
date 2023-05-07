package com.example.androidmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
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

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            // 値が変更された時に呼ばれる
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                TODO("Not yet implemented")
            }

            // seekberに触ったときで呼ばれる
            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            // seekberを離したとき呼ばれる
            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        musicManager.stopMusic()
    }
}