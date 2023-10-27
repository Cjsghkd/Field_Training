package com.example.main.view.util

import android.animation.ValueAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.main.databinding.LiveListItemBinding

internal fun initAnimator(binding: LiveListItemBinding) {
    val valueAnimator = ValueAnimator.ofInt(1, 150).apply {
        addUpdateListener {
            binding.rank.layoutParams = binding.rank.layoutParams.also {
                it.width = this.animatedValue as Int
            }
        }
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
    }
    valueAnimator.start()
}