package com.example.main.view.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.widget.NestedScrollView

internal class StickyScrollView : NestedScrollView, ViewTreeObserver.OnGlobalLayoutListener {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)
    constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    ) {
        overScrollMode = OVER_SCROLL_NEVER
        viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    var header: View? = null
    var appbar: View? = null

    private var headerInitPosition = 0f
    private var appbarHeight = 0f

    override fun onGlobalLayout() {
        headerInitPosition = header?.top?.toFloat() ?: 0f
        appbarHeight = appbar?.bottom?.toFloat() ?: 0f
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        if (t > (headerInitPosition - appbarHeight)) {
            stickHeader(t - headerInitPosition)
        } else {
            freeHeader()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        viewTreeObserver.removeOnGlobalLayoutListener(this)
    }

    private fun stickHeader(position: Float) {
        header?.translationZ = 1f
        header?.translationY = position + appbarHeight
    }

    private fun freeHeader() { header?.translationY = 0f }
}
