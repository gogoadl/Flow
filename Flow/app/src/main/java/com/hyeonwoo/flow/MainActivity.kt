package com.hyeonwoo.flow

import android.media.AudioManager
import android.media.MediaActionSound
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val SAMPLE_URL = "https://grepp-programmers-challenges.s3.ap-northeast-2.amazonaws.com/2020-flo/music.mp3"

    var mediaPlayer : MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var text_singer : TextView = findViewById(R.id.text_singer)
        var text_song : TextView = findViewById(R.id.text_song)
        var text_lyrics : TextView = findViewById(R.id.text_lyrics)
        var btn_play : Button = findViewById(R.id.btn_play)
        var btn_next : Button = findViewById(R.id.btn_next)
        var btn_previous : Button = findViewById(R.id.btn_previous)
        var sb_play : SeekBar = findViewById(R.id.sb_play)
        var img_album : ImageView = findViewById(R.id.img_album)

        text_singer.setOnClickListener(this)
        text_song.setOnClickListener(this)
        text_lyrics.setOnClickListener(this)
        btn_next.setOnClickListener(this)
        btn_play.setOnClickListener(this)
        btn_previous.setOnClickListener(this)

        getJsonArrayFromUrl("https://grepp-programmers-challenges.s3.ap-northeast-2.amazonaws.com/2020-flo/song.json")
    }

    fun getJsonArrayFromUrl(url : String) {
        try {
            val apiResponse = URL(url).readText()

            Log.d("apiResponse", apiResponse)
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }


    fun playAudio() {
        try {

            var mediaPlayer = MediaPlayer().apply {
                setDataSource(SAMPLE_URL)
                setOnPreparedListener(this)
                prepareAsync()
            }

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    private fun setOnPreparedListener(mediaPlayer: MediaPlayer) {
        mediaPlayer.start()
    }


    fun closePlayer() {
        if (mediaPlayer != null) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            // Music Click Event
            R.id.btn_previous -> { }

            R.id.btn_play ->
            {
                try {

                    playAudio()
//                    var mediaPlayer = MediaPlayer().apply {
//                        setDataSource(SAMPLE_URL)
//
//                        prepare()
//                        start()
//                    }

                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }

            R.id.btn_next -> { }

        }
    }
}