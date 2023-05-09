package com.example.androidmusic

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {
    private lateinit var mediaPlayer: MediaPlayer
    private val myContext: Context = context

    fun startMusic() {
        // MediaPlayer型のmediaPlayer変数にMediaPlayerクラスのcreateメソッドで音楽を挿入
        mediaPlayer = MediaPlayer.create(myContext,R.raw.debussy_clair_de_lune)
        // mediaPlayer型のmediaPlayer変数のisLooping変数にtrueを代入
        mediaPlayer.isLooping = true
        // mediaPlayer変数のstartメソッド呼び出し
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

    fun getDuration(): Int {
        // 曲の秒数を取得
        return mediaPlayer.duration
    }

    fun getPosition(): Int {
        // 現在の再生位置を取得
        return mediaPlayer.currentPosition
    }

    fun setSeekMsec(msec: Int) {
        mediaPlayer.seekTo(msec)
    }

    fun intToSec(num: Int): String {
        val min = num / 60
        val sec = num % 60
        return "$min".padStart(2, '0') + ":" + "$sec".padStart(2, '0')
    }
}