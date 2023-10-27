package com.example.main.view.adapter.extension

import android.widget.ImageView
import com.example.main.R

fun loadHeartImage(risingYn: String, imageView: ImageView) {
    if (risingYn != "y") loadImage(imageView = imageView, url = R.drawable.heart)
    else loadImage(imageView = imageView, url = R.drawable.ico_booster_2)
}