package com.malviyastudio.myassignment.ApiService


import com.malviyastudio.myassignment.Model.FlowerModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v3/db9421b8-df8d-4371-b352-517d530b765b")
    fun getFlowerData(): Call<List<FlowerModel>>
}