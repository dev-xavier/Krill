package com.xavier.system_bar.kts

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment


///////////////////////////////////////////////////////////////////////////
// status bar
///////////////////////////////////////////////////////////////////////////

fun Fragment.statusBarHeight(): Int = activity?.statusBarHeight() ?: 0

fun Fragment.statusBarPhysicsHeight(): Int = activity?.statusBarHeight() ?: 0

fun Fragment.statusBarIsVisible(): Boolean = activity?.statusBarIsVisible() ?: false

fun Fragment.statusBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    activity?.statusBarColor(color)

fun Fragment.statusBarTransparent() = activity?.statusBarTransparent()

fun Fragment.statusBarLightMode() = activity?.statusBarLightMode()

fun Fragment.statusBarDarkMode() = activity?.statusBarDarkMode()

fun Fragment.showStatusBar() = activity?.showStatusBar()

fun Fragment.hideStatusBar() = activity?.hideStatusBar()


///////////////////////////////////////////////////////////////////////////
// navigation bar
///////////////////////////////////////////////////////////////////////////

fun Fragment.navigationBarHeight(): Int = activity?.navigationBarHeight() ?: 0

fun Fragment.navigationBarPhysicsHeight(): Int = activity?.navigationBarPhysicsHeight() ?: 0

fun Fragment.navigationBarIsVisible(): Boolean = activity?.statusBarIsVisible() ?: false

fun Fragment.navigationBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    activity?.navigationBarColor(color)

fun Fragment.navigationBarTransparent() = activity?.statusBarTransparent()

fun Fragment.navigationBarLightMode() = activity?.navigationBarLightMode()

fun Fragment.navigationBarDarkMode() = activity?.navigationBarDarkMode()

fun Fragment.showNavigationBar() = activity?.showNavigationBar()

fun Fragment.hideNavigationBar() = activity?.hideNavigationBar()


///////////////////////////////////////////////////////////////////////////
// system bar and other
///////////////////////////////////////////////////////////////////////////

fun Fragment.systemBarColor(@ColorInt color: Int = Color.TRANSPARENT) =
    activity?.systemBarColor(color)

fun Fragment.systemBarTransparent() = activity?.systemBarTransparent()

fun Fragment.systemBarLightMode() = activity?.systemBarLightMode()

fun Fragment.systemBarDarkMode() = activity?.systemBarDarkMode()

fun Fragment.showSystemBar() = activity?.showSystemBar()

fun Fragment.hideSystemBar() = activity?.hideSystemBar()

fun Fragment.lightDarkModeByUiDayNight() = activity?.lightDarkModeByUiDayNight()

fun Fragment.lightDarkModeByColorLuminance(@ColorInt color: Int) =
    activity?.lightDarkModeByColorLuminance(color)

fun Fragment.fullScreen(decorFitsSystemWindows: Boolean = false) =
    activity?.fullScreen(decorFitsSystemWindows)

fun Fragment.immersiveStatusBar() = activity?.immersiveStatusBar()

fun Fragment.immersiveSystemBar() = activity?.immersiveSystemBar()
