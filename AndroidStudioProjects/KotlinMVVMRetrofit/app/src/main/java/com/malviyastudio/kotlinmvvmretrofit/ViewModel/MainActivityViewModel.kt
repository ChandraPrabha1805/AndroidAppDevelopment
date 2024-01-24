package com.malviyastudio.kotlinmvvmretrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import com.malviyastudio.kotlinmvvmretrofit.Repositories.MainRepo

class MainActivityViewModel :ViewModel(){
    private val mainRepo:MainRepo
    val getFlowerList:LiveData<MutableList<FlowerModel>?>
        get() = mainRepo.getFlowerModelLiveData
    init {
        mainRepo= MainRepo()
    }
}