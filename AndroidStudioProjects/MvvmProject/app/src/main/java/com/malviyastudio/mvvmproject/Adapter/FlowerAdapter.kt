package com.malviyastudio.mvvmproject.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.malviyastudio.mvvmproject.Model.FlowerData
import com.malviyastudio.myassignment.databinding.ActivityMainBinding
import com.malviyastudio.myassignment.databinding.RecyclerviewLayoutBinding


class FlowerAdapter:RecyclerView.Adapter<MainViewHolder>() {
    var flrList = mutableListOf<FlowerData>()
    fun setFlowerList(flowers: List<FlowerData>) {
        this.flrList=flowers.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewLayoutBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val flr = flrList[position]
        holder.binding.textView.text = flr.name
        Glide.with(holder.itemView.context).load(flr.imgurl).into(holder.binding.ImageView)
    }
    override fun getItemCount(): Int {
        return flrList.size
    }
}
    class MainViewHolder(val binding: RecyclerviewLayoutBinding):RecyclerView.ViewHolder(binding.root){
    }


