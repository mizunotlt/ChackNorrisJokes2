package com.mizunotlt.chacknorrisjokes2.di.module

import com.mizunotlt.chacknorrisjokes2.data.JokesApi
import com.mizunotlt.chacknorrisjokes2.repository.JokesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule{

    @Provides
    @Singleton
    fun provideRepository(api: JokesApi): JokesRepository {
        return JokesRepository(api)
    }

}