package com.malviyastudio.mvvmproject.Network

import com.malviyastudio.mvvmproject.Model.FlowerData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("/v3/db9421b8-df8d-4371-b352-517d530b765b")
    fun getFlower(): Call<List<FlowerData>>

    companion object{
        var retrofitService:RetrofitService?=null
        fun getInstance():RetrofitService{
            if(retrofitService==null){
        val retrofit=Retrofit.Builder()
                     .baseUrl("https://run.mocky.io/")
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
}}
