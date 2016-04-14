package com.shiva0705.sample.musicfy.data.api.core

import com.shiva0705.sample.musicfy.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class SpotifyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {

        var request = chain?.request()

        request = request?.newBuilder()
                ?.addHeader("Authorization", "Bearer " + BuildConfig.SPOTIFY_ACCESS_TOKEN)
                ?.build();

        var response = chain?.proceed(request)
        return response
    }
}
