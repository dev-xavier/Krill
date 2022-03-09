package com.xavier.system_bar.utils

import android.graphics.Color
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object NavigationBarUtils {

    // NOTE 获取导航栏高度
    //  当 navigation bar 隐藏时 getInsets() 获取的高度为 0
    //  The insets are only available if the view is attached.
    fun navigationBarHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)
            ?.getInsets(WindowInsetsCompat.Type.navigationBars())?.bottom ?: 0
    }

    // NOTE 获取导航栏物理高度
    //  在 navigation bar 隐藏时也能获取高度
    //  The insets are only available if the view is attached.
    fun navigationBarPhysicsHeight(view: View): Int {
        return ViewCompat.getRootWindowInsets(view)
            ?.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())?.bottom ?: 0
    }

    // NOTE 获取导航栏是否可见
    //  The insets are only available if the view is attached.
    fun navigationBarIsVisible(view: View): Boolean {
        return ViewCompat.getRootWindowInsets(view)
            ?.isVisible(WindowInsetsCompat.Type.navigationBars()) ?: true
    }

    // NOTE 设置导航栏背景颜色
    fun navigationBarColor(window: Window, @ColorInt color: Int = Color.TRANSPARENT) {
        window.navigationBarColor = color
    }

    // NOTE 设置导航栏背景透明
    fun navigationBarTransparent(window: Window) {
        window.navigationBarColor = Color.TRANSPARENT
    }

    // NOTE 设置导航栏亮色模式
    //  The insets are only available if the view is attached.
    fun navigationBarLightMode(view: View) {
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
    }

    // NOTE 设置导航栏暗色模式
    //  The insets are only available if the view is attached.
    fun navigationBarDarkMode(view: View) {
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = false
    }

    // NOTE 显示导航栏
    //  The insets are only available if the view is attached.
    fun showNavigationBar(view: View) {
        ViewCompat.getWindowInsetsController(view)?.show(WindowInsetsCompat.Type.navigationBars())
    }

    // NOTE 隐藏导航栏
    //  The insets are only available if the view is attached.
    fun hideNavigationBar(view: View) {
        ViewCompat.getWindowInsetsController(view)?.hide(WindowInsetsCompat.Type.navigationBars())
    }

}