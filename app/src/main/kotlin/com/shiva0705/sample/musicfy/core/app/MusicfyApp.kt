package com.shiva0705.sample.musicfy.core.app

import android.app.Application
import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider

class MusicfyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        AppComponentProvider.build(this)
    }

    companion object {
        lateinit var sInstance: MusicfyApp
        val instance: MusicfyApp
            get() = sInstance
    }
}