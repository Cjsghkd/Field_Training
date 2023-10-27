package com.example.main.view.adapter.extension

import android.widget.ImageView
import com.example.main.R

fun loadGenderImage(bjMemSex: String, imageView: ImageView) {
    if (bjMemSex == "f") loadImage(imageView = imageView, url = R.drawable.ico_female)
    else loadImage(imageView = imageView, url = R.drawable.ico_male)
}