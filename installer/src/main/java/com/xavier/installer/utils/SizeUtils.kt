package com.xavier.installer.utils

import android.content.res.Resources

object SizeUtils

val Int.dp2px: Int
    get() {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }

val Float.dpTpx: Float
    get() {
        val scale = Resources.getSystem().displayMetrics.density
        return this * scale + 0.5f
    }