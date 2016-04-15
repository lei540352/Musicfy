package com.shiva0705.sample.musicfy.data.api.core

import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.data.preferences.SpotifyPreference
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class SpotifyInterceptor : Interceptor {

    @Inject lateinit var spotifyPref : SpotifyPreference

    override fun intercept(chain: Interceptor.Chain?): Response? {

        AppComponentProvider.appComponent.inject(this)

        var request = chain?.request()

        request = request?.newBuilder()
                ?.addHeader("Authorization", "Bearer " + spotifyPref.getAuthToken())
                ?.build();

        var response = chain?.proceed(request)
        return response
    }
}
