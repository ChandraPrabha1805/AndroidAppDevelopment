package com.malviyastudio.myassignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malviyastudio.myassignment.Model.FlowerModel
import com.malviyastudio.myassignment.Repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerViewModel(private val repository: Repository) : ViewModel() {

    private val _flowerList = MutableLiveData<List<FlowerModel>>()
    // Expose LiveData to the outside for observation
    val flowerList: LiveData<List<FlowerModel>> get() = _flowerList

    fun fetchFlowerData() {
        repository.getFlowerData().enqueue(object : Callback<List<FlowerModel>> {
            override fun onResponse(call: Call<List<FlowerModel>>, response: Response<List<FlowerModel>>) {
                if (response.isSuccessful) {
                    _flowerList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<FlowerModel>>, t: Throwable) {
                // Handle failure if needed
            }
        })
    }
}
