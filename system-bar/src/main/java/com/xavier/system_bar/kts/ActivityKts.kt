package com.xavier.system_bar.kts

import android.app.Activity
import android.graphics.Color
import androidx.annotation.ColorInt
import com.xavier.system_bar.utils.NavigationBarUtils
import com.xavier.system_bar.utils.StatusBarUtils
import com.xavier.system_bar.utils.SystemBarUtils


///////////////////////////////////////////////////////////////////////////
// status bar
///////////////////////////////////////////////////////////////////////////

fun Activity.statusBarHeight(): Int = StatusBarUtils.statusBarHeight(window.decorView)

fun Activity.statusBarPhysicsHeight(): Int = StatusBarUtils.statusBarPhysicsHeight(window.decorView)

fun Activity.statusBarIsVisible(): Boolean = StatusBarUtils.statusBarIsVisible(window.decorView)

fun Activity.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT) = window.statusBarColor(color)

fun Activity.statusBarTransparent() = window.statusBarTransparent()

fun Activity.statusBarLightMode() = StatusBarUtils.statusBarLightMode(window.decorView)

fun Activity.statusBarDarkMode() = StatusBarUtils.statusBarDarkMode(window.decorView)

fun Activity.showStatusBar() = StatusBarUtils.showStatusBar(window.decorView)

fun Activity.hideStatusBar() = StatusBarUtils.hideStatusBar(window.decorView)


///////////////////////////////////////////////////////////////////////////
// navigation bar
///////////////////////////////////////////////////////////////////////////

fun Activity.navigationBarHeight(): Int = NavigationBarUtils.navigationBarHeight(window.decorView)

fun Activity.navigationBarPhysicsHeight(): Int =
    NavigationBarUtils.navigationBarPhysicsHeight(window.decorView)

fun Activity.navigationBarIsVisible(): Boolean =
    NavigationBarUtils.navigationBarIsVisible(window.decorView)

fun Activity.navigationBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    window.navigationBarColor(color)

fun Activity.navigationBarTransparent() = window.navigationBarTransparent()

fun Activity.navigationBarLightMode() = NavigationBarUtils.navigationBarLightMode(window.decorView)

fun Activity.navigationBarDarkMode() = NavigationBarUtils.navigationBarDarkMode(window.decorView)

fun Activity.showNavigationBar() = NavigationBarUtils.showNavigationBar(window.decorView)

fun Activity.hideNavigationBar() = NavigationBarUtils.hideNavigationBar(window.decorView)


///////////////////////////////////////////////////////////////////////////
// system bar and other
///////////////////////////////////////////////////////////////////////////

fun Activity.systemBarColor(@ColorInt color: Int = Color.TRANSPARENT) = window.systemBarColor(color)

fun Activity.systemBarTransparent() = window.systemBarTransparent()

fun Activity.systemBarLightMode() = SystemBarUtils.systemBarLightMode(window.decorView)

fun Activity.systemBarDarkMode() = SystemBarUtils.systemBarDarkMode(window.decorView)

fun Activity.showSystemBar() = SystemBarUtils.showSystemBar(window.decorView)

fun Activity.hideSystemBar() = SystemBarUtils.hideSystemBar(window.decorView)

fun Activity.lightDarkModeByUiDayNight() = window.lightDarkModeByUiDayNight(this)

fun Activity.lightDarkModeByColorLuminance(@ColorInt color: Int) =
    window.lightDarkModeByColorLuminance(color)

fun Activity.fullScreen(decorFitsSystemWindows: Boolean = false) =
    window.fullScreen(decorFitsSystemWindows)

fun Activity.immersiveStatusBar() = window.immersiveStatusBar()

fun Activity.immersiveSystemBar() = window.immersiveSystemBar()