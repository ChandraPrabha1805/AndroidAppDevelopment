package com.malviyastudio.mvvmproject.Network

import com.malviyastudio.mvvmproject.Model.FlowerData
import retrofit2.Call
import retrofit2.http.GET

interface FlowerApi {
  @GET("/v3/db9421b8-df8d-4371-b352-517d530b765b")
  fun getFlower(): Call<List<FlowerData>>
}