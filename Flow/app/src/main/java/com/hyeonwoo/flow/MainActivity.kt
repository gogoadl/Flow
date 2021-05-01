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
import com.google.android.exoplayer2.SimpleExoPlayer
import org.w3c.dom.Text
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var player : SimpleExoPlayer? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}