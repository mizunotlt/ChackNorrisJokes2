package com.mizunotlt.chacknorrisjokes2.di.module

import com.mizunotlt.chacknorrisjokes2.models.JokesModel
import com.mizunotlt.chacknorrisjokes2.repository.JokesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule{

    @Provides
    @Singleton
    fun provideViewModels(repository: JokesRepository): JokesModel {
        return JokesModel(repository)
    }
}