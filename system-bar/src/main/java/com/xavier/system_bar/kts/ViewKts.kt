package com.xavier.system_bar.kts

import android.view.View
import com.xavier.system_bar.utils.StatusBarUtils

fun View.statusBarHeight() = StatusBarUtils.statusBarHeight(this)

fun View.statusBarPhysicsHeight() = StatusBarUtils.statusBarPhysicsHeight(this)

fun View.statusBarIsVisible() = StatusBarUtils.statusBarIsVisible(this)