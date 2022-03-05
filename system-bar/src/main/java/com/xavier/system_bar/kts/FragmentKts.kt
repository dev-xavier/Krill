package com.xavier.system_bar.kts

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment

fun Fragment.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT) = activity?.statusBarColor(color)

fun Fragment.statusBarTransparent() =  activity?.statusBarTransparent()