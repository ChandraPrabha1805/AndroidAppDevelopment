package com.malviyastudio.kotlinmvvmretrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import com.malviyastudio.kotlinmvvmretrofit.Repositories.MainRepo

class MainActivityViewModel :ViewModel(){
    private var mainRepo: MainRepo = MainRepo()
    val getFlowerList: LiveData<List<FlowerModel>?> = mainRepo.getFlowerModelLiveData

    init {
        mainRepo= MainRepo()
    }
}