package com.xavier.installer

import android.content.Context

class KrillInstaller private constructor(context: Context) {

    init {
        appContext = context
    }

    companion object {
        @Volatile
        private var INSTANCE: KrillInstaller? = null
        @Volatile
        lateinit var appContext: Context
            private set

        fun init(context: Context) {
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: KrillInstaller(context).also { INSTANCE = it }
            }
        }
    }
}