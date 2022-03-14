package com.xavier.krill.view.event_dispatch

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import com.xavier.krill.print
import com.xavier.krill.test.event_dispatch.EventDispatchActivity
import timber.log.Timber

@SuppressLint("ClickableViewAccessibility")
class EventDispatchViewGroup : ViewGroup {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Timber.tag(EventDispatchActivity.TAG).d(ev.print())
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Timber.tag(EventDispatchActivity.TAG).d(ev.print())
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Timber.tag(EventDispatchActivity.TAG).d(event.print())
        return super.onTouchEvent(event)
    }

}