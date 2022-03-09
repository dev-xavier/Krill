package com.xavier.krill.utils

import android.content.res.Resources

object SizeUtils

val Int.dp2px: Int
    get() {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }

val Float.dp2px: Float
    get() {
        val scale = Resources.getSystem().displayMetrics.density
        return this * scale + 0.5f
    }