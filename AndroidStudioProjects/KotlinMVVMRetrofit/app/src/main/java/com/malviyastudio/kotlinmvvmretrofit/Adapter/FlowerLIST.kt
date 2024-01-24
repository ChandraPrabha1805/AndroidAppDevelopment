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
import java.security.AccessControlContext

class FlowerLIST (var context: Context,var flowerModelList: MutableList<FlowerModel>):
RecyclerView.Adapter<FlowerLIST.MyViewModel>()
{
   inner class MyViewModel(itemView: View):RecyclerView.ViewHolder(itemView)
    {
     var image:ImageView
     var flowerName:TextView
     var flowerclr:TextView

     init {
         flowerclr=itemView.findViewById(R.id.flowerclr)
         flowerName=itemView.findViewById(R.id.flowerName)
         image=itemView.findViewById(R.id.image)

     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_flower_list,parent,false))
    }

    override fun getItemCount(): Int {
return flowerModelList.size  }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        Picasso.get().load(flowerModelList[position].imgurl).into(holder.image)
        holder.flowerName.text=flowerModelList[position].name
        holder.flowerclr.text=flowerModelList[position].tag


    }
}