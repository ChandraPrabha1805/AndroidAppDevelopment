package com.malviyastudio.kotlinmvvmretrofit.Common

import com.malviyastudio.kotlinmvvmretrofit.Network.ApiService
import com.malviyastudio.kotlinmvvmretrofit.Network.Retrofit

object Common {
    private const val BASE_URL="https://run.mocky.io/"
    val getApiService:ApiService
        get() = Retrofit.getRetrofitClient(BASE_URL).create(ApiService::class.java)
}