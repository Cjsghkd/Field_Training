package com.example.main.view.adapter.extension

import android.widget.ImageView
import com.example.main.R

fun loadMiniImage(typeMedia: String, imageView: ImageView) {
    when(typeMedia) {
        "v" -> {
            loadImage(imageView = imageView, url = R.drawable.ico_video)
        }
    }
}