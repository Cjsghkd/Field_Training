package com.example.publishing_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.publishing_practice.R
import com.example.publishing_practice.databinding.LiveListItemBinding
import com.example.publishing_practice.databinding.NewListItemBinding
import com.example.publishing_practice.model.LiveRecyclerViewRequestModel
import com.example.publishing_practice.model.NewRecyclerViewRequestModel

class LiveBjAdapter(var itemList: List<LiveRecyclerViewRequestModel>): RecyclerView.Adapter<LiveBjAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.live_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LiveListItemBinding.bind(itemView)

        fun bind(item: LiveRecyclerViewRequestModel) {
            Glide.with(itemView).load(item.background).into(binding.background)
            Glide.with(itemView).load(item.gender).into(binding.genderImg)
            Glide.with(itemView).load(item.heart).into(binding.heartImg)
            Glide.with(itemView).load(item.rank).into(binding.rank)
            Glide.with(itemView).load(item.miniIcon).into(binding.liveMiniIcon)
            binding.title.text = item.title
            binding.name.text = item.name
            binding.peopleCount.text = item.peopleCount
            binding.heartCount.text = item.heartCount
        }
    }
}