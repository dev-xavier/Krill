package com.xavier.system_bar.utils

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import androidx.core.view.WindowCompat
import com.xavier.installer.KrillInstaller

/**
 * LINK 确保与手势导航兼容 https://developer.android.google.cn/training/gestures/gesturenav
 *  开启全面屏体验 | 手势导航 (一) https://mp.weixin.qq.com/s/DEI4bcmKkRBySUjO2AYEJA
 *  处理视觉冲突 | 手势导航 (二) https://juejin.cn/post/6844904006343458830
 *  Android Detail：Window 篇—— WindowInsets 与 fitsSystemWindow https://juejin.cn/post/7038422081528135687#heading-27
 *  WindowInsets — listeners to layouts https://medium.com/androiddevelopers/windowinsets-listeners-to-layouts-8f9ccc8fa4d1
 */
object SystemBarUtils {

    // NOTE 是否是暗色模式
    fun isNightMode(context: Context = KrillInstaller.appContext): Boolean {
        return (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    }

    // NOTE 设置 system bar 的背景颜色
    fun systemBarColor(window: Window, @ColorInt color: Int = Color.TRANSPARENT) {
        StatusBarUtils.statusBarColor(window, color)
        NavigationBarUtils.navigationBarColor(window, color)
    }

    // NOTE 设置 system bar 背景透明
    fun systemBarTransparent(window: Window) {
        StatusBarUtils.statusBarTransparent(window)
        NavigationBarUtils.navigationBarTransparent(window)
    }

    // NOTE 设置 system bar 亮色模式
    fun systemBarLightMode(view: View) {
        StatusBarUtils.statusBarLightMode(view)
        NavigationBarUtils.navigationBarLightMode(view)
    }

    // NOTE 设置 system bar 暗色模式
    fun systemBarDarkMode(view: View) {
        StatusBarUtils.statusBarDarkMode(view)
        NavigationBarUtils.navigationBarDarkMode(view)
    }

    // NOTE 显示 system bar
    fun showSystemBar(view: View) {
        StatusBarUtils.showStatusBar(view)
        NavigationBarUtils.showNavigationBar(view)
    }

    // NOTE 隐藏 system bar
    fun hideSystemBar(view: View) {
        StatusBarUtils.hideStatusBar(view)
        NavigationBarUtils.hideNavigationBar(view)
    }

    // NOTE 根据日夜间模式设置 system bar 亮/暗色
    fun lightDarkModeByUiDayNight(view: View, context: Context = KrillInstaller.appContext) {
        if (isNightMode(context)) {
            systemBarDarkMode(view)
        } else {
            systemBarLightMode(view)
        }
    }

    // NOTE 根据 color 亮度设置 system bar 亮/暗色
    fun lightDarkModeByColorLuminance(window: Window, @ColorInt color: Int) {
        systemBarColor(window, color)
        val decorView = window.decorView
        if (ColorUtils.calculateLuminance(color) < 0.5) {
            systemBarDarkMode(decorView)
        } else {
            systemBarLightMode(decorView)
        }
    }

    // NOTE 请求进行全屏布局
    fun fullScreen(window: Window, decorFitsSystemWindows: Boolean = false) {
        WindowCompat.setDecorFitsSystemWindows(window, decorFitsSystemWindows)
    }

    // NOTE 沉浸式状态栏
    //  The insets are only available if the view is attached.
    fun immersiveStatusBar(window: Window) {
        fullScreen(window, false)
        StatusBarUtils.statusBarTransparent(window)
    }

    // NOTE 沉浸式系统栏
    //  The insets are only available if the view is attached.
    fun immersiveSystemBar(window: Window) {
        immersiveStatusBar(window)
        NavigationBarUtils.hideNavigationBar(window.decorView)
    }

}