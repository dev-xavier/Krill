package com.xavier.krill.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.xavier.krill.MainApplication

object ResourceUtils

@ColorInt
fun @receiver:ColorRes Int.color(context: Context = MainApplication.appContext): Int {
    return ContextCompat.getColor(context, this)
}

fun @receiver:DrawableRes Int.drawable(context: Context = MainApplication.appContext): Drawable? =
    ContextCompat.getDrawable(context, this)
