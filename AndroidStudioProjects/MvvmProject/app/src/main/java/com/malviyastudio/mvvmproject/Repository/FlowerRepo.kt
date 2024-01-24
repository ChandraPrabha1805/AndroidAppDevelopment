package com.malviyastudio.mvvmproject.Repository

import com.malviyastudio.mvvmproject.Network.RetrofitService

class FlowerRepo constructor(private val retrofitService: RetrofitService){
    fun getFlowerData()=retrofitService.getFlower()
}