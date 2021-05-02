package com.hyeonwoo.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.hyeonwoo.flow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    * 요구사항 정리하기
    * 1. 음악 재생은 Foreground Service 또는 Worker 이용이 필요 해 보임. -> Background 이동 후 상태 바에서 슬라이드로 삭제가 불가능하므로.
    * 2. 음악 재생바 (Exoplayer), Fragment선택 바는 Activity에 고정하고, 위의 뷰는 navigation 이용하여 화면 전환하기
    * */

    /* lateInit 예약어 - 프로퍼티의 선언과 동시에 초기화하지 않아도 된다.
    * var로 선언한 프로퍼티에만 사용할 수 있다.
    * null 허용 프로퍼티에는 사용할 수 없다.
    * 기초타입 프로퍼티에는 사용할 수 없다.
    */
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Kotlin Extensions가 deprecated 되었으므로, View Binding을 사용하도록 변경
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navController = findNavController(R.id.nav_host_fragment)


        binding.btnHome.setOnClickListener { navController.navigate(R.id.homeFragment) }
        binding.btnBrowse.setOnClickListener { navController.navigate(R.id.browseFragment) }
        binding.btnSearch.setOnClickListener { navController.navigate(R.id.searchFragment) }
        binding.btnLocker.setOnClickListener { navController.navigate(R.id.lockerFragment) }

    }

}