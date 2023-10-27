package com.example.main.view.adapter.extension

import android.widget.ImageView
import com.example.main.R

fun loadRankImage(dayLiveDjRank: Int, imageView: ImageView) {
    when(dayLiveDjRank) {
        1 -> {
            loadImage(imageView = imageView, url = R.drawable.ani_time_01)
        }
        2 -> {
            loadImage(imageView = imageView, url = R.drawable.ani_time_02)
        }
        3 -> {
            loadImage(imageView = imageView, url = R.drawable.ani_time_03)
        }
    }
}