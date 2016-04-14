package com.shiva0705.sample.sampleApp.core.app

import android.app.Application
import com.shiva0705.sample.musicfy.core.dagger.components.AppComponent
import com.shiva0705.sample.musicfy.core.dagger.components.PreferenceComponent

class MusicfyApp : Application() {

    lateinit var appComponent: AppComponent
    lateinit var prefComponent: PreferenceComponent

    override fun onCreate() {
        super.onCreate()
        sInstance = this

    }

    fun getAppComponents() = appComponent


    companion object {
        lateinit var sInstance: MusicfyApp
        val instance: MusicfyApp
            get() = sInstance
    }
}