package com.example.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.FollowingListItemBinding
import com.example.model.model.model.star.StarModel

internal class FollowingBjAdapter(var itemList: List<StarModel>): RecyclerView.Adapter<FollowingBjAdapter.ViewHolderPage>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPage {
        val binding = FollowingListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPage(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolderPage, position: Int) = holder.bind(itemList[position])

    class ViewHolderPage(val binding: FollowingListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StarModel) {
            binding.followingList = item
        }
    }
}
