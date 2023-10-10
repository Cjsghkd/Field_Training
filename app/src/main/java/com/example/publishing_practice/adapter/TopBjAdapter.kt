package com.example.publishing_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.publishing_practice.R
import com.example.publishing_practice.databinding.TopListItemBinding
import com.example.publishing_practice.model.TopRecyclerViewRequestModel

class TopBjAdapter(var itemList: List<TopRecyclerViewRequestModel>): RecyclerView.Adapter<TopBjAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TopListItemBinding.bind(itemView)

        fun bind(item: TopRecyclerViewRequestModel) {
            Glide.with(itemView).load(item.background).into(binding.background)
            Glide.with(itemView).load(item.rank).into(binding.rank)
            Glide.with(itemView).load(item.icon).into(binding.miniIcon)
            binding.name.text = item.name
        }
    }
}