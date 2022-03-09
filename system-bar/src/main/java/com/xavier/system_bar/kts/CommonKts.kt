package com.xavier.system_bar.kts

import android.content.Context
import com.xavier.installer.KrillInstaller
import com.xavier.system_bar.utils.SystemBarUtils

fun Any.isNightMode(context: Context = KrillInstaller.appContext): Boolean = SystemBarUtils.isNightMode(context)