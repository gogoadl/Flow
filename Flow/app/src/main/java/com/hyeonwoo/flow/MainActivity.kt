package com.hyeonwoo.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.SimpleExoPlayer

class MainActivity : AppCompatActivity() {
    /*
    * 요구사항 정리하기
    * 1. 음악 재생은 Foreground Service 또는 Worker 이용이 필요 해 보임. -> Background 이동 후 상태 바에서 슬라이드로 삭제가 불가능하므로.
    * 2. 음악 재생바 (Exoplayer), Fragment선택 바는 Activity에 고정하고, 위의 뷰는 navigation 이용하여 화면 전환하기
    *
    * */
    private var player : SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}