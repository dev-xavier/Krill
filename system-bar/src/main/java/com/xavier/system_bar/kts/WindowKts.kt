package com.xavier.system_bar.kts

import android.graphics.Color
import android.view.Window
import androidx.annotation.ColorInt
import com.xavier.system_bar.utils.StatusBarUtils

fun Window.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT) = StatusBarUtils.statusBarColor(this,color)

fun Window.statusBarTransparent() = StatusBarUtils.statusBarTransparent(this)