package com.example.main.view.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.main.R

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

    @BindingAdapter("risingYn")
    @JvmStatic
    fun loadHeartImageUrl(imageView: ImageView, risingYn: String) {
        if (risingYn == "y") Glide.with(imageView.context).load(R.drawable.ico_booster_2).thumbnail(0.1f).into(imageView)
        else Glide.with(imageView.context).load(R.drawable.heart).thumbnail(0.1f).into(imageView)
    }

    @BindingAdapter("typeMedia")
    @JvmStatic
    fun loadMiniImageUrl(imageView: ImageView, typeMedia: String) {
        when (typeMedia) {
            "v" -> { Glide.with(imageView.context).load(R.drawable.ico_video).into(imageView) }
        }
    }

    @BindingAdapter("bjMemSex")
    @JvmStatic
    fun loadGenderImageUrl(imageView: ImageView, bjMemSex: String) {
        if (bjMemSex == "f") Glide.with(imageView.context).load(R.drawable.ico_female).into(imageView)
        else Glide.with(imageView.context).load(R.drawable.ico_male).into(imageView)
    }

    @BindingAdapter("dayLiveDjRank")
    @JvmStatic
    fun loadRankImageUrl(imageView: ImageView, dayLiveDjRank: Int) {
        when (dayLiveDjRank) {
            1 -> { Glide.with(imageView.context).load(R.drawable.ani_time_01).into(imageView) }
            2 -> { Glide.with(imageView.context).load(R.drawable.ani_time_02).into(imageView) }
            3 -> { Glide.with(imageView.context).load(R.drawable.ani_time_03).into(imageView) }
        }
    }
}