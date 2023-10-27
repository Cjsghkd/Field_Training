package com.example.main.view.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

internal fun RecyclerView.setItemDecoration(defaultMarginInDp: Int) {
    val density = resources.displayMetrics.density

    addItemDecoration(object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            val totalItemCount = state.itemCount

            when(position) {
                0 -> {
                    outRect.set((16 * density).toInt(), 0, (defaultMarginInDp * density).toInt(), 0)
                }
                (totalItemCount - 1) -> {
                    outRect.set((defaultMarginInDp * density).toInt(), 0, (16 * density).toInt(), 0)
                }
                else -> {
                    outRect.set((defaultMarginInDp * density).toInt(), 0, (defaultMarginInDp * density).toInt(), 0)
                }
            }
        }
    })
}
