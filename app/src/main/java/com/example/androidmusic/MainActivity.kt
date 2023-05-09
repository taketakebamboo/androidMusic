package com.example.androidmusic

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.androidmusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Runnable{
    private val musicManager: MusicManager = MusicManager(this@MainActivity)
    private var startFlag: Boolean = false
    private lateinit var binding: ActivityMainBinding
    private val handler: Handler = Handler(Looper.getMainLooper())
    private var playPosition: Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // playButtonとposeButtonを押したときの処理と画像処理
        binding.playImage.setOnClickListener {
            when(startFlag) {
                false -> {
                    musicManager.startMusic()
                    startFlag = true
                    binding.seekBar.max = musicManager.getDuration() / 1000
                    binding.playImage.setImageResource(R.drawable.posebutton_300x300)
                    musicManager.setSeekMsec(playPosition)
                    handler.postDelayed(this,0)
                }
                true -> {
                    playPosition = musicManager.getPosition()
                    musicManager.stopMusic()
                    startFlag = false
                    binding.playImage.setImageResource(R.drawable.playbutton_300x300)
                    handler.removeCallbacks(this)
                }
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            // 値が変更された時に呼ばれる
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.musicSec.text = musicManager.intToSec(progress)
            }

            // seekbarに触ったときで呼ばれる
            override fun onStartTrackingTouch(p0: SeekBar?) {
                // TODO("Not yet implemented")
            }

            // seekbarを離したとき呼ばれる
            override fun onStopTrackingTouch(p0: SeekBar?) {
                playPosition = binding.seekBar.progress * 1000
                if(startFlag){
                    musicManager.setSeekMsec(binding.seekBar.progress * 1000)
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        musicManager.stopMusic()
    }

    override fun run() {
        if(startFlag) {
            musicCount()
        }
        handler.postDelayed(this,1000)
    }

    private fun musicCount() {
        binding.seekBar.progress = musicManager.getPosition() / 1000
        binding.musicSec.text = musicManager.intToSec(binding.seekBar.progress)
    }
}