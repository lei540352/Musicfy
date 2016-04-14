package com.shiva0705.sample.musicfy.core.dagger.modules

import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.data.preferences.SpotifyPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule(){

    @Provides @Singleton
    fun provideSelectionPreference(): SelectionPreference = SelectionPreference()

    @Provides @Singleton
    fun providesSpotifyPreference() : SpotifyPreference = SpotifyPreference()

}