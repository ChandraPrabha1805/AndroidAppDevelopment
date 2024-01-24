package com.malviyastudio.kotlinmvvmretrofit.Repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.malviyastudio.kotlinmvvmretrofit.Common.Common
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import com.malviyastudio.kotlinmvvmretrofit.Network.ApiService
import retrofit2.Call
import retrofit2.Response

class MainRepo {
    private val ApiService: ApiService
    companion object {
        private const val TAG="MainRepo"
    }
  init {
      ApiService= Common.getApiService
  }
    val getFlowerModelLiveData:MutableLiveData<MutableList<FlowerModel>?>
        get() {
            val data:MutableLiveData<MutableList<FlowerModel>?> =
            MutableLiveData<MutableList<FlowerModel>?>(null)
         ApiService.getFlowerlist().enqueue(object :retrofit2.Callback<MutableList<FlowerModel>>{
             override fun onResponse(
                 call: Call<MutableList<FlowerModel>>,
                 response: Response<MutableList<FlowerModel>>
             ) {
                 Log.e(TAG,"onResponse "+ response.code())
                 if (response.isSuccessful){
                     data.value=response.body()
                 }else {
                     data.value=null
                 }
                 }

             override fun onFailure(call: Call<MutableList<FlowerModel>>, t: Throwable) {
                 Log.e(TAG,"onResponse "+ t.message)
                 data.value=null
             }

         })
            return data
        }
}