import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter

import androidx.recyclerview.widget.RecyclerView
import com.malviyastudio.myassignment.Model.FlowerModel
import com.malviyastudio.myassignment.databinding.LayoutFlowerBinding

import com.squareup.picasso.Picasso


class FlowerAdapter : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    var flowerList: List<FlowerModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: LayoutFlowerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(flowerModel: FlowerModel) {
            binding.nameTextView.text = flowerModel.name
            binding.orderTextView.text = flowerModel.order
            binding.tagTextView.text = flowerModel.tag

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutFlowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFlower = flowerList[position]
        holder.bind(currentFlower)

    }
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrBlank()) {
            Picasso.get().load(imageUrl).into(view)
        }
    }
    override fun getItemCount(): Int {
        return flowerList.size
    }
}
