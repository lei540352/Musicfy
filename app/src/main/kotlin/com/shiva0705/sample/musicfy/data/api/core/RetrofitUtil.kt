package com.shiva0705.sample.musicfy.data.api.core

import com.shiva0705.sample.musicfy.BuildConfig
import com.shiva0705.sample.musicfy.data.api.SpotifyApi
import com.shiva0705.sample.musicfy.data.api.core.serializationUtils.CustomGsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitUtil{

    fun spotifyApi() : SpotifyApi {

        var logInteceptor = HttpLoggingInterceptor()
        logInteceptor.level = HttpLoggingInterceptor.Level.BODY

        var httpClient = OkHttpClient().newBuilder()
                    .addInterceptor(SpotifyInterceptor())
                    .addInterceptor (logInteceptor)
                    .build()


        return getApiInstance(SpotifyApi::class.java, httpClient)
    }

    private fun <T> getApiInstance(apiClass: Class<T>, httpClient : OkHttpClient): T {

        val restAdapter = Retrofit.Builder()
                .baseUrl(BuildConfig.SPOTIFY_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(CustomGsonBuilder.build()))
                .client(httpClient)
                .build()

        val api = restAdapter.create(apiClass)
        return api
    }

}