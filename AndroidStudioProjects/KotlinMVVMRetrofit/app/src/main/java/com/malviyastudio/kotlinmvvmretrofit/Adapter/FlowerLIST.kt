package com.malviyastudio.kotlinmvvmretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import com.malviyastudio.kotlinmvvmretrofit.R
import com.squareup.picasso.Picasso

class FlowerLIST(var context: Context, var flowerModelList: List<FlowerModel>):
RecyclerView.Adapter<FlowerLIST.MyViewModel>()
{
   inner class MyViewModel(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var image: ImageView
        var flowerName: TextView
        var flowerOrder: TextView
        var flowerTag: TextView


        init {
            image = itemView.findViewById(R.id.image)
            flowerName = itemView.findViewById(R.id.flowerName)
            flowerOrder = itemView.findViewById(R.id.flowerOrder)
            flowerTag = itemView.findViewById(R.id.flowerTag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_flower_list,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val flower = flowerModelList[position]
        Picasso.get().load(flower.imgurl).into(holder.image)
        // Set text for other views
        holder.flowerName.text = flower.name
        holder.flowerOrder.text = flower.order
        holder.flowerTag.text = flower.tag

    }
    override fun getItemCount(): Int {
    return flowerModelList.size  }

    }
