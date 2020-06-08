package com.mizunotlt.chacknorrisjokes2

import android.app.Application
import android.content.Context
import com.mizunotlt.chacknorrisjokes2.di.components.AppComponent
import com.mizunotlt.chacknorrisjokes2.di.components.DaggerAppComponent


class App: Application(){

    companion object {
        lateinit var appContext: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appComponent = initDagger()
    }

    private fun initDagger(): AppComponent {
        return DaggerAppComponent.builder()
            .build()
    }

}