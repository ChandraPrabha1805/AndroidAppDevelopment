package com.malviyastudio.myassignment.Repository

import com.malviyastudio.myassignment.ApiService.ApiService
import com.malviyastudio.myassignment.Model.FlowerModel
import retrofit2.Call

class Repository (private val apiService: ApiService) {

    fun getFlowerData(): Call<List<FlowerModel>> {
        return apiService.getFlowerData()
    }
}