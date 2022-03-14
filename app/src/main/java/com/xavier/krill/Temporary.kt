package com.xavier.krill

import android.annotation.SuppressLint
import android.view.KeyEvent.ACTION_DOWN
import android.view.KeyEvent.ACTION_UP
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_CANCEL
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.internal.ViewUtils.requestApplyInsetsWhenAttached

// LINK WindowInsets — listeners to layouts https://medium.com/androiddevelopers/windowinsets-listeners-to-layouts-8f9ccc8fa4d1
@SuppressLint("RestrictedApi")
fun View.doOnApplyWindowInsets(f: (View, WindowInsetsCompat, InitialPadding) -> Unit) {
    // Create a snapshot of the view's padding state
    val initialPadding = recordInitialPaddingForView(this)
    // Set an actual OnApplyWindowInsetsListener which proxies to the given
    // lambda, also passing in the original padding state
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        f(v, insets, initialPadding)
        // Always return the insets, so that children can also use them
        insets
    }
    // request some insets
    requestApplyInsetsWhenAttached(this)
}

data class InitialPadding(
    val left: Int, val top: Int,
    val right: Int, val bottom: Int
)

private fun recordInitialPaddingForView(view: View) = InitialPadding(
    view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom
)

@BindingAdapter(
    "paddingLeftSystemWindowInsets",
    "paddingTopSystemWindowInsets",
    "paddingRightSystemWindowInsets",
    "paddingBottomSystemWindowInsets",
    requireAll = false
)
fun applySystemWindows(
    view: View,
    applyLeft: Boolean,
    applyTop: Boolean,
    applyRight: Boolean,
    applyBottom: Boolean
) {
    view.doOnApplyWindowInsets { _, insets, padding ->
        insets.run {
            val left = if (applyLeft) getInsets(WindowInsetsCompat.Type.systemBars()).left else 0
            val top = if (applyTop) getInsets(WindowInsetsCompat.Type.systemBars()).top else 0
            val right = if (applyRight) getInsets(WindowInsetsCompat.Type.systemBars()).right else 0
            val bottom =
                if (applyBottom) getInsets(WindowInsetsCompat.Type.systemBars()).bottom else 0
            view.setPadding(
                padding.left + left,
                padding.top + top,
                padding.right + right,
                padding.bottom + bottom
            )
        }
    }
}

fun MotionEvent?.print(): String {
    if(this==null){
        return "null"
    }
    return when (action) {
        ACTION_DOWN -> "ACTION_DOWN"
        ACTION_UP -> "ACTION_UP"
        ACTION_CANCEL -> "ACTION_CANCEL"
        else -> "其他"
    }
}