package com.malviyastudio.kotlinmvvmretrofit.Repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.malviyastudio.kotlinmvvmretrofit.Common.Common
import com.malviyastudio.kotlinmvvmretrofit.Model.ApiResponse
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
    val getFlowerModelLiveData: MutableLiveData<List<FlowerModel>?> get() {
        val data: MutableLiveData<List<FlowerModel>?> = MutableLiveData(null)

        ApiService.getFlowerlist().enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                Log.e(TAG, "onResponse " + response.code())

                if (response.isSuccessful) {
                    val flowerModelList = response.body()?.images.orEmpty()
                    data.value = flowerModelList
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, "onFailure " + t.message)
                data.value = null
            }
        })

        return data
    }
}
