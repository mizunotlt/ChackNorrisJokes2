package com.mizunotlt.chacknorrisjokes2.di.module

import android.content.Context
import com.mizunotlt.chacknorrisjokes2.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: App): Context = app.applicationContext

}