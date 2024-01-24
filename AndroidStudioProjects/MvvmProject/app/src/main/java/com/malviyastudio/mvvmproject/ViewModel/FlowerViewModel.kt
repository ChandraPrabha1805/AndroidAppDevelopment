package com.malviyastudio.mvvmproject.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malviyastudio.mvvmproject.Model.FlowerData
import com.malviyastudio.mvvmproject.Repository.FlowerRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerViewModel  constructor(private val repository : FlowerRepo):ViewModel(){
    val flowerList =MutableLiveData<List<FlowerData>>()
    val errorMsg=MutableLiveData<String>()

    fun getAllFlowers(){
        val response =repository.getFlowerData()
        response.enqueue(object : Callback<List<FlowerData>>{
            override fun onResponse(
                call: Call<List<FlowerData>>,
                response: Response<List<FlowerData>>
            ) {
                flowerList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<FlowerData>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }

        })
    }
}