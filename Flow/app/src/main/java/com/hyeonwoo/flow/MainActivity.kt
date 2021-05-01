package com.hyeonwoo.flow

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    * 요구사항 정리하기
    * 1. 음악 재생은 Foreground Service 또는 Worker 이용이 필요 해 보임. -> Background 이동 후 상태 바에서 슬라이드로 삭제가 불가능하므로.
    * 2. 음악 재생바 (Exoplayer), Fragment선택 바는 Activity에 고정하고, 위의 뷰는 navigation 이용하여 화면 전환하기
    *
    * */
    private lateinit var appBarConfiguration: AppBarConfiguration

    private var player : SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializePlayer()

        var navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        btn_home.setOnClickListener { navController.navigate(R.id.homeFragment) }
        btn_browse.setOnClickListener { navController.navigate(R.id.browseFragment) }
        btn_search.setOnClickListener { navController.navigate(R.id.searchFragment) }
        btn_locker.setOnClickListener { navController.navigate(R.id.lockerFragment) }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initializePlayer() {
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(this)
            main_pcv.player = player
            main_pcv.showTimeoutMs = 0
            val defaultHttpDataSourceFactory =
                DefaultHttpDataSourceFactory(getString(R.string.app_name))
//            val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory)
//                .createMediaSource(Uri.parse(songUrl))
//            player!!.prepare(mediaSource)
        }
    }
}