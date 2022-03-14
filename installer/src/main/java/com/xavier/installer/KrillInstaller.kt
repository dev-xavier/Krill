package com.xavier.installer

import android.content.Context

class KrillInstaller private constructor() {

    companion object {
        @Volatile
        private var INSTANCE: KrillInstaller? = null

        @Volatile
        lateinit var appContext: Context
            private set

        fun init(context: Context) {
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: KrillInstaller().also {
                    appContext = context
                    INSTANCE = it
                }
            }
        }
    }
}