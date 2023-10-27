package com.example.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.main.R
import com.example.main.databinding.NewListItemBinding
import com.example.model.model.model.example.NewRecyclerViewRequestModel

internal class NewBjAdapter(var itemList: List<NewRecyclerViewRequestModel>): RecyclerView.Adapter<NewBjAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = NewListItemBinding.bind(itemView)

        fun bind(item: NewRecyclerViewRequestModel) {
            Glide.with(itemView).load(item.background).transform(CenterCrop(), RoundedCorners(24)).into(binding.background)
            binding.name.text = item.name
        }
    }
}