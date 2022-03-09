package com.xavier.krill.utils

import android.content.Context
import android.widget.Toast
import com.xavier.krill.MainApplication
import com.xavier.krill.api.LOGIC_INT_INIT_VALUE

object ToastUtils

fun String?.toast(
    context: Context = MainApplication.appContext,
    duration: Int = LOGIC_INT_INIT_VALUE
) {
    if (isNullOrEmpty()) return
    val durationFinal = if (duration == Toast.LENGTH_SHORT || duration == Toast.LENGTH_LONG) {
        duration
    } else {
        if (length < 16) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    }
    Toast.makeText(context, this, durationFinal).show()
}