package com.shiva0705.sample.musicfy.core.dagger.componentProvider

import android.app.Application
import com.shiva0705.sample.musicfy.core.dagger.components.AppComponent
import com.shiva0705.sample.musicfy.core.dagger.components.DaggerAppComponent
import com.shiva0705.sample.musicfy.core.dagger.modules.ApiModule
import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.core.dagger.modules.DomainModule
import com.shiva0705.sample.musicfy.core.dagger.modules.PreferenceModule

object AppComponentProvider {

    lateinit var appComponent: AppComponent

    fun build(app : Application){
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .apiModule(ApiModule())
                .preferenceModule(PreferenceModule())
                .domainModule(DomainModule())
                .build()
    }
}


