package com.hyeonwoo.flow.viewmodel


import com.hyeonwoo.flow.model.SongData
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("song.json")
    fun getSongData() : retrofit2.Call<SongData>
}