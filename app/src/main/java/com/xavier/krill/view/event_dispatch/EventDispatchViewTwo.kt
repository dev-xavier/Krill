package com.xavier.krill.view.event_dispatch

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.xavier.krill.print
import com.xavier.krill.test.event_dispatch.EventDispatchActivity
import timber.log.Timber

@SuppressLint("ClickableViewAccessibility")
class EventDispatchViewTwo : View {
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

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Timber.tag(EventDispatchActivity.TAG).d(event.print())
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Timber.tag(EventDispatchActivity.TAG).d(event.print())
        return super.onTouchEvent(event)
    }

}