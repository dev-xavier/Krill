package com.xavier.krill

import android.app.Application
import android.content.Context
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appContext = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Timber is initialized.")
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
        lateinit var application: MainApplication
            private set
    }

}