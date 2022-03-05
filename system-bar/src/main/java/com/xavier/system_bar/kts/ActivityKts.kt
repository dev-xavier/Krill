package com.xavier.system_bar.kts

import android.app.Activity
import android.graphics.Color
import androidx.annotation.ColorInt

fun Activity.statusBarHeight(): Int = window.decorView.statusBarHeight()

fun Activity.statusBarPhysicsHeight(): Int = window.decorView.statusBarPhysicsHeight()

fun Activity.statusBarIsVisible(): Boolean = window.decorView.statusBarIsVisible()

fun Activity.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT): Unit =
    window.statusBarColor(color)

fun Activity.statusBarTransparent(): Unit = window.statusBarTransparent()