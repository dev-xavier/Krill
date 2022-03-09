package com.xavier.krill.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xavier.krill.R

class FullScreenExperienceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_experience)
        stepOne()
        stepTwo()
    }

    private fun stepTwo() {
        // 在 AndroidManifest 中完成
    }

    // 请求进行全屏布局
    private fun stepOne() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

}