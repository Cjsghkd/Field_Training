package com.example.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.LiveListItemBinding
import com.example.main.view.adapter.extension.visibilityImage
import com.example.model.model.model.room.RoomModel

internal class LiveBjAdapter(var itemList: List<RoomModel>): RecyclerView.Adapter<LiveBjAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LiveListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

    class ViewHolder(val binding: LiveListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RoomModel) {
            binding.liveList = item

            visibilityImage(image = item.toggle, imageView = binding.toggle)
            visibilityImage(image = item.teamMedalUrl, imageView = binding.medalImg)
        }
    }
}