package com.example.androidmusic

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {
    private lateinit var mediaPlayer: MediaPlayer
    private val myContext: Context = context

    fun stertMusic() {
        // MediaPlayer型のmediaPlayer変数にMediaPlayerクラスのcreateメソッドで音楽を挿入
        mediaPlayer = MediaPlayer.create(myContext,R.raw.debussy_clair_de_lune)
        // mediaPlayer型のmediaPlayer変数のisLooping変数にtrueを代入
        mediaPlayer.isLooping = true
        // mediaPlayer変数のstertメソッド呼び出し
        mediaPlayer.start()
    }

    fun stopMusic() {
        // mediaPlayer変数のstopメソッド呼び出し
        mediaPlayer.stop()
        // mediaPlayer変数のresetメソッド呼び出し
        mediaPlayer.reset()
        // mediaPlayer変数のreleaseメソッド呼び出し
        mediaPlayer.release()
    }
}