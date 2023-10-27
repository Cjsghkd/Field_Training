package com.example.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.MainBannerItemBinding
import com.example.model.model.model.main_banner.MainBannerModel

internal class MainBannerAdapter(private val list: List<MainBannerModel>) : RecyclerView.Adapter<MainBannerAdapter.ViewHolderPage>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPage {
        val binding = MainBannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPage(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderPage, position: Int) = holder.bind(list[position % list.size])

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolderPage(val binding: MainBannerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MainBannerModel) {
            binding.mainBanner = item
        }
    }
}