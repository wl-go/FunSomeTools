package com.wlcookies.funsometools

import android.app.Application
import com.wlcookies.library.config.LoggerConfig

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        LoggerConfig.init("wl", BuildConfig.DEBUG)
    }
}