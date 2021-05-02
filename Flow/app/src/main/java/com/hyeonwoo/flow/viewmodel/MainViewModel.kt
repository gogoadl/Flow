package com.hyeonwoo.flow.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel

import com.hyeonwoo.flow.model.SongData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel(application: Application): AndroidViewModel(application){
    /* ViewModel의 역할은 UI 관련 데이터를 저장하고 관리한다.
    * 사용자가 앱의 화면을 전환한다면 시스템의 UI 컨트롤러가 종료되어 기존의 데이터를 잃어 버리게 된다.
    * onSaveInstance를 사용할 수 있지만 데이터의 값이 복잡하거나 양이 많아질 경우에는 Memory Leak 현상과 리소스 낭비 등 문제가 발생한다.
    */

    fun getJsonRequest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://grepp-programmers-challenges.s3.ap-northeast-2.amazonaws.com/2020-flo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitAPI::class.java)

        val callService = service.getSongData()

        callService.enqueue(object : Callback<SongData> {
            override fun onResponse(call: Call<SongData>, response: Response<SongData>) {
                var result = response.body()
                Log.d("result %s",result.toString())
            }

            override fun onFailure(call: Call<SongData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

