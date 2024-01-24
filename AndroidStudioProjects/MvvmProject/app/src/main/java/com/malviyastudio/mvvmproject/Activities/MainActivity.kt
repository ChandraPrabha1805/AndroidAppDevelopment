package com.malviyastudio.mvvmproject.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.malviyastudio.mvvmproject.Adapter.FlowerAdapter
import com.malviyastudio.mvvmproject.Network.RetrofitService
import com.malviyastudio.mvvmproject.Repository.FlowerRepo
import com.malviyastudio.mvvmproject.ViewModel.FlowerViewModel
import com.malviyastudio.mvvmproject.ViewModelFactory
import com.malviyastudio.myassignment.R
import com.malviyastudio.myassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: FlowerViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = FlowerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.recyclerView.setLayoutManager(LinearLayoutManager(this));
        viewModel = ViewModelProvider(this, ViewModelFactory(FlowerRepo(retrofitService)))
            .get(FlowerViewModel::class.java)

        binding.recyclerView.adapter=adapter
        viewModel.flowerList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setFlowerList(it)
        })
        viewModel.errorMsg.observe(this, Observer {
        })
        viewModel.getAllFlowers()
    }
}