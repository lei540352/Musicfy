package com.shiva0705.sample.musicfy.core.dagger.components

import com.shiva0705.sample.musicfy.core.dagger.modules.ApiModule
import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.core.dagger.modules.PreferenceModule
import com.shiva0705.sample.musicfy.ui.activities.MainActivity
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment
import dagger.Component
import javax.inject.Singleton


@Singleton @Component(modules = arrayOf(PreferenceModule::class, ApiModule::class, AppModule::class))
interface AppComponent {

    fun inject(obj : MainActivity);
    fun inject(locationListFragment : SelectSongFragment);

}