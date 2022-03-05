package com.xavier.system_bar.utils

import android.content.Context
import android.content.res.Configuration
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import com.xavier.installer.KrillInstaller

/**
 * LINK 确保与手势导航兼容 https://developer.android.google.cn/training/gestures/gesturenav
 *  开启全面屏体验 | 手势导航 (一) https://mp.weixin.qq.com/s/DEI4bcmKkRBySUjO2AYEJA
 *  处理视觉冲突 | 手势导航 (二) https://juejin.cn/post/6844904006343458830
 *  Android Detail：Window 篇—— WindowInsets 与 fitsSystemWindow https://juejin.cn/post/7038422081528135687#heading-27
 */
object SystemBarUtils {

    fun isNightMode(context: Context = KrillInstaller.appContext): Boolean {
        return (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    }

    // NOTE 请求进行全屏布局
    fun fullScreen(view: View){
        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    // NOTE 根据日夜间模式设置 system bar 亮暗色默认
    fun lightDarkModeByUiDayNight(view: View, context: Context = KrillInstaller.appContext) {
        if(isNightMode(context)){
            StatusBarUtils.statusBarDarkMode(view)
            NavigationBarUtils.navigationBarDarkMode(view)
        }else{
            StatusBarUtils.statusBarLightMode(view)
            NavigationBarUtils.navigationBarLightMode(view)
        }
    }

    // NOTE 根据 color 亮度设置 system bar 亮暗色默认
    fun lightDarkModeByColorLuminance(view: View,@ColorInt color: Int) {
        if (ColorUtils.calculateLuminance(color) < 0.5) {
            StatusBarUtils.statusBarDarkMode(view)
            NavigationBarUtils.navigationBarDarkMode(view)
        } else {
            StatusBarUtils.statusBarLightMode(view)
            NavigationBarUtils.navigationBarLightMode(view)
        }
    }

}