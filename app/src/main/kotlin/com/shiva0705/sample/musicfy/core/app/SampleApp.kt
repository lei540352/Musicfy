package com.shiva0705.sample.musicfy.core.app

import android.app.Application
import com.shiva0705.sample.musicfy.core.dagger.components.AppComponent
import com.shiva0705.sample.musicfy.core.dagger.components.DaggerAppComponent
import com.shiva0705.sample.musicfy.core.dagger.components.DaggerPreferenceComponent
import com.shiva0705.sample.musicfy.core.dagger.components.PreferenceComponent
import com.shiva0705.sample.musicfy.core.dagger.modules.ApiModule
import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.core.dagger.modules.PreferenceModule

class MusicfyApp : Application() {

    lateinit var appComponent: AppComponent
    lateinit var prefComponent: PreferenceComponent

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .apiModule(ApiModule())
                    .preferenceModule(PreferenceModule())
                    .build()

        prefComponent = DaggerPreferenceComponent.builder()
                .appModule(AppModule(this))
                .build()

    }

    fun getAppComponents() = appComponent


    companion object {
        lateinit var sInstance: MusicfyApp
        val instance: MusicfyApp
            get() = sInstance
    }
}