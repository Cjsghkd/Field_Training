package com.example.main.view.adapter.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(imageView: ImageView, url: Int) {
    Glide.with(imageView.context).load(url).thumbnail(0.1f).into(imageView)
}