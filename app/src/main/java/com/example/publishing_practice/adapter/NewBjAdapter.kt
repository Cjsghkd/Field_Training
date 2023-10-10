package com.example.publishing_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.publishing_practice.R
import com.example.publishing_practice.databinding.NewListItemBinding
import com.example.publishing_practice.model.NewRecyclerViewRequestModel

class NewBjAdapter(var itemList: List<NewRecyclerViewRequestModel>): RecyclerView.Adapter<NewBjAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = NewListItemBinding.bind(itemView)

        fun bind(item: NewRecyclerViewRequestModel) {
            Glide.with(itemView).load(item.background).into(binding.background)
            binding.name.text = item.name
        }
    }
}