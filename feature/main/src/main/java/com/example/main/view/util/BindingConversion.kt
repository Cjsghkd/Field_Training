package com.example.main.view.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

object BindingConversion {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).thumbnail(0.1f).into(imageView)
    }

    @BindingAdapter("circleImageUrl")
    @JvmStatic
    fun loadCircleImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).optionalCircleCrop().thumbnail(0.1f).into(imageView)
    }

    @BindingAdapter("drawableImageUrl")
    @JvmStatic
    fun loadDrawableImage(imageView: ImageView, url: Int) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @BindingAdapter("roundImageUrl")
    @JvmStatic
    fun loadRoundImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).transform(CenterCrop(), RoundedCorners(24)).thumbnail(0.1f).into(imageView)
    }
}