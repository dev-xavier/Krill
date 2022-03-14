package com.xavier.krill.test

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xavier.krill.MainActivity
import com.xavier.krill.R
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityThirdLaunchBinding


/**
 * LINK
 *  第三方唤醒APP以及四种启动模式的思考 https://www.jianshu.com/p/d1df1b92d6b3
 *  浏览器点击链接打开指定APP详解 https://blog.csdn.net/qq_41716624/article/details/96000817
 *  html 见 assets/third.html
 */
class ThirdLaunchActivity : ViewBindingActivity<ActivityThirdLaunchBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_launch)
        if (!isOtherUIExisting(applicationContext)) {
            startActivity(Intent(context, MainActivity::class.java))
        }
        finish()
    }

    /**
     * 判断是否有别的页面存在
     *
     * @param context
     * @return
     */
    private fun isOtherUIExisting(context: Context): Boolean {
        var existing = false
        try {
            val currClassName = javaClass.name
            val currPackageName = packageName
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val list = am.getRunningTasks(10)
            if (list.size <= 0) {
                existing = false
            }
            for (info in list) {
                val activityName = info.baseActivity?.className
                if (activityName == currClassName) {
                    continue
                }
                if (info.baseActivity?.packageName == currPackageName) {
                    existing = true
                    break
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            existing = false
        }
        return existing
    }
}