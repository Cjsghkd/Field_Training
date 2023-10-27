package com.example.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.main.R
import com.example.main.databinding.AdvertisementBannerItemBinding
import com.example.main.databinding.FollowingListItemBinding
import com.example.model.model.model.ad_banner.AdBannerModel
import com.example.model.model.model.star.StarModel

internal class AdvertisementBannerAdapter(private val list: List<AdBannerModel>) : RecyclerView.Adapter<AdvertisementBannerAdapter.ViewHolderPage>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPage {
        val binding = AdvertisementBannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPage(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderPage, position: Int) = holder.bind(list[position % list.size])

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolderPage(val binding: AdvertisementBannerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AdBannerModel) {
            binding.adBanner = item
        }
    }
}