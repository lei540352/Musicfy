package com.shiva0705.sample.musicfy.core.dagger.modules

import com.shiva0705.sample.musicfy.data.api.SpotifyApi
import com.shiva0705.sample.musicfy.data.api.core.RetrofitUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule(){

    @Provides @Singleton
    fun provideSpotifyApi() : SpotifyApi = RetrofitUtil.spotifyApi()
}