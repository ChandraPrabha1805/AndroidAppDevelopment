package com.malviyastudio.kotlinmvvmretrofit

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malviyastudio.kotlinmvvmretrofit.Adapter.FlowerLIST
import com.malviyastudio.kotlinmvvmretrofit.ViewModel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: FlowerLIST? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog : AlertDialog? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView?.let { rv ->
            rv.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this)
            rv.layoutManager = layoutManager

            mainActivityViewModel?.getFlowerList?.observe(this) { FlowerModel ->
                FlowerModel?.let {
                    Log.e("MainActivity", "FlowerList " + it.getOrNull(0)?.name)

                    adapter = FlowerLIST(this, it)
                    adapter?.notifyDataSetChanged()
                    rv.adapter = adapter
                }
            }
        } ?: run {
            Log.e("MainActivity", "RecyclerView is null")
        }
    }
}