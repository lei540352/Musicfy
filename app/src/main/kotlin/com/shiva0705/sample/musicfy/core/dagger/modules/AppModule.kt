package com.shiva0705.sample.musicfy.core.dagger.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app : Application){

    @Provides @Singleton
    fun provideApp() : Application = app;

    @Provides @Singleton
    fun provideSharedPrefernces() : SharedPreferences =  app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)

}