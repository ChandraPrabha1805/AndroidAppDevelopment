package com.malviyastudio.myassignment.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malviyastudio.myassignment.Model.FlowerModel
import com.malviyastudio.myassignment.Repository.Repository

class ViewModelFactory(private val repository:Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlowerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

