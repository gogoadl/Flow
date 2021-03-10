package com.hyeonwoo.flow

import android.media.AudioManager
import android.media.MediaActionSound
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val SAMPLE_URL = "https://grepp-programmers-challenges.s3.ap-northeast-2.amazonaws.com/2020-flo/music.mp3"

    var mediaPlayer : MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_lock : Button = findViewById(R.id.btn_look)
        var btn_play_list : Button = findViewById(R.id.btn_play_list)
        var btn_play : Button = findViewById(R.id.btn_play)
        var btn_next_play : Button = findViewById(R.id.btn_next_play)
        var btn_previous_play : Button = findViewById(R.id.btn_previous_play)
        var btn_profile : Button = findViewById(R.id.btn_profile)
        var btn_search : Button = findViewById(R.id.btn_search)
        var btn_home : Button = findViewById(R.id.btn_home)

        btn_lock.setOnClickListener(this)
        btn_play_list.setOnClickListener(this)
        btn_play.setOnClickListener(this)
        btn_next_play.setOnClickListener(this)
        btn_previous_play.setOnClickListener(this)
        btn_profile.setOnClickListener(this)
        btn_search.setOnClickListener(this)
        btn_home.setOnClickListener(this)


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
            // Fragment Click Event
            R.id.btn_home ->
            {


            }
            R.id.btn_look -> { }
            R.id.btn_search -> { }
            R.id.btn_profile -> { }
            // Music Click Event
            R.id.btn_previous_play -> { }

            R.id.btn_play ->
            {
                try {

                    var mediaPlayer = MediaPlayer().apply {
                        setDataSource(SAMPLE_URL)
                        
                        prepare()
                        start()
                    }

                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }

            R.id.btn_next_play -> { }
            R.id.btn_play_list -> { }

        }
    }
}