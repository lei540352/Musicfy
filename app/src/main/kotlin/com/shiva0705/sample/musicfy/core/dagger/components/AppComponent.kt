package com.shiva0705.sample.musicfy.core.dagger.components

import com.shiva0705.sample.musicfy.core.dagger.modules.ApiModule
import com.shiva0705.sample.musicfy.core.dagger.modules.AppModule
import com.shiva0705.sample.musicfy.core.dagger.modules.DomainModule
import com.shiva0705.sample.musicfy.core.dagger.modules.PreferenceModule
import com.shiva0705.sample.musicfy.data.api.core.SpotifyInterceptor
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.data.preferences.SpotifyPreference
import com.shiva0705.sample.musicfy.domain.GameEngine
import com.shiva0705.sample.musicfy.domain.ScoreCompiler
import com.shiva0705.sample.musicfy.domain.Scorer
import com.shiva0705.sample.musicfy.ui.activities.MainActivity
import com.shiva0705.sample.musicfy.ui.activities.SplashActivity
import com.shiva0705.sample.musicfy.ui.fragments.GameResultFragment
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment
import dagger.Component
import javax.inject.Singleton


@Singleton @Component(modules = arrayOf(PreferenceModule::class, ApiModule::class, AppModule::class, DomainModule::class))
interface AppComponent {

    fun inject(obj : MainActivity)
    fun inject(obj : SplashActivity)
    fun inject(songListFragment: SelectSongFragment)
    fun inject(obj : GameResultFragment)

    fun inject(obj : SpotifyInterceptor)

    fun inject(obj : Scorer)
    fun inject(obj : ScoreCompiler)
    fun inject(obj : GameEngine)

    fun inject(obj : SelectionPreference);
    fun inject(obj : SpotifyPreference);

}