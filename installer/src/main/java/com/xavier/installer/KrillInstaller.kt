package com.xavier.installer

import android.content.Context

class KrillInstaller private constructor(applicationContext: Context) {

    init {
        appContext = applicationContext
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var INSTANCE: KrillInstaller? = null
        fun init(context: Context) {
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: KrillInstaller(context).also { INSTANCE = it }
            }
        }

        @Volatile
        lateinit var appContext: Context
            private set
    }
}