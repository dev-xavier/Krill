package com.xavier.krill.test

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivitySystemBarBinding
import com.xavier.krill.utils.toast
import com.xavier.system_bar.kts.*
import com.xavier.system_bar.utils.SystemBarUtils
import kotlinx.coroutines.flow.*
import timber.log.Timber

class SystemBarActivity : ViewBindingActivity<ActivitySystemBarBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {}
    }

    fun isNightModeClick(view: View) {
        if (isNightMode()) {
            "暗色模式"
        } else {
            "亮色模式"
        }.toast()
    }

    fun systemBarColorClick(view: View) {
        systemBarColor(Color.RED)
    }

    fun systemBarTransparentClick(view: View) {
        systemBarTransparent()
    }

    fun systemBarLightModeClick(view: View) {
        systemBarLightMode()
    }

    fun systemBarDarkModeClick(view: View) {
        systemBarDarkMode()
    }

    fun showSystemBarClick(view: View) {
        showSystemBar()
    }

    fun hideSystemBarClick(view: View) {
        hideSystemBar()
    }

    fun lightDarkModeByUiDayNightClick(view: View) {
        lightDarkModeByUiDayNight()
    }

    fun lightDarkModeByColorLuminanceClick(view: View) {
        lightDarkModeByColorLuminance(Color.BLUE)
    }

    fun fullScreenFalseClick(view: View) {
        fullScreen()
    }

    fun fullScreenTrueClick(view: View) {
        SystemBarUtils.fullScreen(window, true)
    }

    // 全屏标记 + 状态栏透明 = 沉浸式状态栏?
    fun immersiveStatusBarClick(view: View) {
        fullScreen()
        statusBarTransparent()

    }

    // 全屏标记 + 状态栏透明 + 隐藏导航栏 = 沉浸式系统栏？
    fun immersiveSystemBarClick(view: View) {
        fullScreen()
        statusBarTransparent()
        hideNavigationBar()
    }

    // 边到边？
    fun edgeToEdgeClick(view: View) {
        // 1. 使内容区域全屏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 2. 设置 System bar 透明
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        // 3. 可能出现视觉冲突的 view 处理 insets
        ViewCompat.setOnApplyWindowInsetsListener(view) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // 此处更改的 margin，也可设置 padding，视情况而定
            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
                //leftMargin = insets.left
                //bottomMargin = insets.bottom
                //rightMargin = insets.right
            }
            WindowInsetsCompat.CONSUMED
        }
    }
}