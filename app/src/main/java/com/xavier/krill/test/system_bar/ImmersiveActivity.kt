package com.xavier.krill.test.system_bar

import android.os.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityFullScreenExperienceBinding
import com.xavier.system_bar.kts.fullScreen
import com.xavier.system_bar.kts.hideNavigationBar
import com.xavier.system_bar.kts.systemBarTransparent
import timber.log.Timber
import java.lang.ref.WeakReference

class ImmersiveActivity : ViewBindingActivity<ActivityFullScreenExperienceBinding>() {

    private val handler by lazy { KrillHandler(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = binding.root
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, windowInsets ->
            val visible = windowInsets.isVisible(WindowInsetsCompat.Type.navigationBars())
            Timber.d("visible $visible")
            handler.removeMessages(10086)
            if (visible) {
                handler.sendEmptyMessageDelayed(10086, 2000)
            }
            WindowInsetsCompat.CONSUMED
        }
        fullScreen()
        systemBarTransparent()
        hideNavigationBar()
    }

    private class KrillHandler(activity: ImmersiveActivity) : Handler(Looper.getMainLooper()) {

        private val weakReference = WeakReference(activity)

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 10086) {
                Timber.d("handleMessage 10086")
                weakReference.get()?.hideNavigationBar()
            }
        }
    }
}