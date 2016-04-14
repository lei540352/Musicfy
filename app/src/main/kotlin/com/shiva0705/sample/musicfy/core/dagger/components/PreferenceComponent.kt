package com.shiva0705.sample.musicfy.core.dagger.components

import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import dagger.Component
import javax.inject.Singleton


@Singleton @Component(modules = arrayOf(AppModule::class))
interface PreferenceComponent {
    
    fun inject(SelectionPreference : SelectionPreference);

}