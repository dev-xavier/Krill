package com.xavier.system_bar.utils

import android.graphics.Color
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object StatusBarUtils {

    /**
     * 获取状态栏高度, The insets are only available if the view is attached.
     * @return 状态栏高度 [Int], 在 status bar 隐藏时 [WindowInsetsCompat.getInsets] 获取的高度为 0
     */
    fun statusBarHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)
            ?.getInsets(WindowInsetsCompat.Type.statusBars())?.top ?: 0
    }


    /**
     * 获取状态栏物理高度, The insets are only available if the view is attached.
     * @return 状态栏高度 [Int], 在 status bar 隐藏时也能获取高度
     */
    fun statusBarPhysicsHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)
            ?.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())?.top ?: 0
    }

    /**
     * 状态栏是否可见, The insets are only available if the view is attached.
     * @return true 可见, false 不可见 [Boolean], 在 status bar 隐藏时也能获取高度
     */
    fun statusBarIsVisible(view: View): Boolean {
        return ViewCompat.getRootWindowInsets(view)?.isVisible(WindowInsetsCompat.Type.statusBars())
            ?: true
    }

    /**
     * 设置状态栏背景颜色, The insets are only available if the view is attached.
     * @param window [Window]
     * @param color [ColorInt]
     */
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