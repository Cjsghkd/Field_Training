package com.example.main.view.adapter.extension

import android.view.View
import android.widget.ImageView
import com.example.main.R

fun <T> visibilityImage(image: T?, imageView: ImageView) {
    if (image == null) imageView.visibility = View.GONE
}