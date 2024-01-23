package com.malviyastudio.myassignment

import FlowerAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malviyastudio.myassignment.ApiService.ApiService
import com.malviyastudio.myassignment.Repository.Repository
import com.malviyastudio.myassignment.ViewModel.FlowerViewModel
import com.malviyastudio.myassignment.ViewModel.ViewModelFactory
import com.malviyastudio.myassignment.databinding.ActivityMainBinding
import com.malviyastudio.myassignment.ui.theme.MyAssignmentTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FlowerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel = ViewModelProvider(this).get(FlowerViewModel::class.java)
        viewModel.flowerList.observe(this, { flowerList ->
            (binding.recyclerView.adapter as FlowerAdapter).flowerList = flowerList
        })

        viewModel.fetchFlowerData()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = FlowerAdapter()
        binding.recyclerView.adapter = adapter

    }
}