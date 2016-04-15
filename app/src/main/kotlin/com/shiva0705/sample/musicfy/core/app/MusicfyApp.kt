package com.shiva0705.sample.musicfy.core.app

import android.app.Application
import com.shiva0705.sample.musicfy.core.dagger.components.AppComponent
import com.shiva0705.sample.musicfy.core.dagger.components.DaggerAppComponent
import com.shiva0705.sample.musicfy.core.dagger.modules.ApiModule
import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.core.dagger.modules.DomainModule
import com.shiva0705.sample.musicfy.core.dagger.modules.PreferenceModule

class MusicfyApp : Application() {

    lateinit var appComponent: AppComponent
    
    override fun onCreate() {
        super.onCreate()
        sInstance = this

        appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .apiModule(ApiModule())
                    .preferenceModule(PreferenceModule())
                    .domainModule(DomainModule())
                    .build()
    }

    companion object {
        lateinit var sInstance: MusicfyApp
        val instance: MusicfyApp
            get() = sInstance
    }
}