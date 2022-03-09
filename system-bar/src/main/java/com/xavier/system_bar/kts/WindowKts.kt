package com.xavier.system_bar.kts

import android.content.Context
import android.graphics.Color
import android.view.Window
import androidx.annotation.ColorInt
import com.xavier.installer.KrillInstaller
import com.xavier.system_bar.utils.NavigationBarUtils
import com.xavier.system_bar.utils.StatusBarUtils
import com.xavier.system_bar.utils.SystemBarUtils


///////////////////////////////////////////////////////////////////////////
// status bar
///////////////////////////////////////////////////////////////////////////

fun Window.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    StatusBarUtils.statusBarColor(this, color)

fun Window.statusBarTransparent() = StatusBarUtils.statusBarTransparent(this)


///////////////////////////////////////////////////////////////////////////
// navigation bar
///////////////////////////////////////////////////////////////////////////

fun Window.navigationBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    NavigationBarUtils.navigationBarColor(this, color)

fun Window.navigationBarTransparent() = NavigationBarUtils.navigationBarTransparent(this)


///////////////////////////////////////////////////////////////////////////
// system bar
///////////////////////////////////////////////////////////////////////////

fun Window.systemBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    SystemBarUtils.systemBarColor(this, color)

fun Window.systemBarTransparent() = SystemBarUtils.systemBarTransparent(this)

fun Window.lightDarkModeByUiDayNight(context: Context = KrillInstaller.appContext) =
    SystemBarUtils.lightDarkModeByUiDayNight(decorView)

fun Window.lightDarkModeByColorLuminance(@ColorInt color: Int) =
    SystemBarUtils.lightDarkModeByColorLuminance(this, color)

fun Window.fullScreen(decorFitsSystemWindows: Boolean = false) = SystemBarUtils.fullScreen(this)

fun Window.immersiveStatusBar() = SystemBarUtils.immersiveStatusBar(this)

fun Window.immersiveSystemBar() = SystemBarUtils.immersiveSystemBar(this)
