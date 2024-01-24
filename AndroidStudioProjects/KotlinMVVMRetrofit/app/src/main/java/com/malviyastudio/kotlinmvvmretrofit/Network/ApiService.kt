package com.malviyastudio.kotlinmvvmretrofit.Network

import com.malviyastudio.kotlinmvvmretrofit.Model.ApiResponse
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v3/db9421b8-df8d-4371-b352-517d530b765b")
    fun getFlowerlist(): Call<ApiResponse>

}