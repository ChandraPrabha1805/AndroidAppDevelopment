package com.malviyastudio.mvvmproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malviyastudio.mvvmproject.Repository.FlowerRepo
import com.malviyastudio.mvvmproject.ViewModel.FlowerViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(private val repository:FlowerRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FlowerViewModel::class.java)){
            FlowerViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("ViewModel is not found" )
        }
        }

    }
