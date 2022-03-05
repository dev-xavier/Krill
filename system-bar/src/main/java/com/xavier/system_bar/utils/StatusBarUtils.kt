package com.xavier.system_bar.utils

import android.graphics.Color
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object StatusBarUtils {

    // NOTE 获取状态栏高度
    //  当 status bar 隐藏时 getInsets() 获取的高度为 0
    //  The insets are only available if the view is attached.
    fun statusBarHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)?.getInsets(WindowInsetsCompat.Type.statusBars())?.top ?: 0
    }

    // NOTE 获取状态栏物理高度
    //  在 status bar 隐藏时也能获取高度
    //  The insets are only available if the view is attached.
    fun statusBarPhysicsHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)?.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())?.top ?: 0
    }

    // NOTE 获取状态栏是否可见
    //  The insets are only available if the view is attached.
    fun statusBarIsVisible(view: View): Boolean {
        return ViewCompat.getRootWindowInsets(view)?.isVisible(WindowInsetsCompat.Type.statusBars()) ?: true
    }

    // NOTE 设置状态栏背景颜色
    fun statusBarColor(window: Window, @ColorInt color: Int = Color.TRANSPARENT) {
        window.statusBarColor = color
    }

    // NOTE 设置状态栏背景透明
    fun statusBarTransparent(window: Window) {
        window.statusBarColor = Color.TRANSPARENT
    }

    // NOTE 设置状态栏亮色模式
    //  The insets are only available if the view is attached.
    fun statusBarLightMode(view: View) {
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
    }

    // NOTE 设置状态栏暗色模式
    //  The insets are only available if the view is attached.
    fun statusBarDarkMode(view: View) {
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = false
    }

    // NOTE 显示状态栏
    //  The insets are only available if the view is attached.
    fun showStatusBar(view: View) {
        ViewCompat.getWindowInsetsController(view)?.show(WindowInsetsCompat.Type.statusBars())
    }

    // NOTE 隐藏状态栏
    //  The insets are only available if the view is attached.
    fun hideStatusBar(view: View) {
        ViewCompat.getWindowInsetsController(view)?.hide(WindowInsetsCompat.Type.statusBars())
    }

}