package com.example.superheroe.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroe.data.fichaSuperHeroe
import com.example.superheroe.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso


class SuperheroeAdapter(var items: List<fichaSuperHeroe>, val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = items[position]
        holder.render(superhero)
        holder.itemView.setOnClickListener{
            onItemClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<fichaSuperHeroe>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class ViewHolder(val binding: ItemSuperheroBinding) : RecyclerView.ViewHolder(binding.root){
    fun render(superhero: fichaSuperHeroe) {
        binding.nameTextView.text = superhero.name
        Picasso.get().load(superhero.image.url).into(binding.avatarImageView)
    }
}
