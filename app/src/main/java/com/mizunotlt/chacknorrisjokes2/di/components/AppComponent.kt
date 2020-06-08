package com.mizunotlt.chacknorrisjokes2.di.components

import com.mizunotlt.chacknorrisjokes2.MainActivity
import com.mizunotlt.chacknorrisjokes2.di.module.AppModule
import com.mizunotlt.chacknorrisjokes2.di.module.NetworkModule
import com.mizunotlt.chacknorrisjokes2.di.module.RepositoryModule
import com.mizunotlt.chacknorrisjokes2.JokeFragment
import com.mizunotlt.chacknorrisjokes2.di.module.ViewModelModule
import com.mizunotlt.chacknorrisjokes2.models.JokesModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
@Singleton
interface AppComponent{

    fun inject(activity: MainActivity)
    fun inject(jokeFragment: JokeFragment)
    fun inject(jokesModel: JokesModel)

}