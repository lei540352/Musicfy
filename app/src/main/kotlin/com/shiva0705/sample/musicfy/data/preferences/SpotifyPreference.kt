package com.shiva0705.sample.musicfy.data.preferences

import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.data.preferences.core.BasePreference
import com.shiva0705.sample.musicfy.data.preferences.core.Prefereneces

class SpotifyPreference : BasePreference(){

    init{
        AppComponentProvider.appComponent.inject(this)
    }

    fun saveAuthTokeno(token : String) = commit(Prefereneces.spotify_auth_token, token)

    fun getAuthToken() : String? = read(Prefereneces.spotify_auth_token, String::class.java)
}