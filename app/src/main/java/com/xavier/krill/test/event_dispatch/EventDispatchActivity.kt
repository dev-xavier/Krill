package com.xavier.krill.test.event_dispatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.xavier.krill.R
import com.xavier.krill.print
import timber.log.Timber

class EventDispatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_dispatch)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Timber.tag(TAG).d(ev.print())
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Timber.tag(TAG).d(event.print())
        return super.onTouchEvent(event)
    }

    companion object{
        const val TAG = "event_dispatch"
    }

}