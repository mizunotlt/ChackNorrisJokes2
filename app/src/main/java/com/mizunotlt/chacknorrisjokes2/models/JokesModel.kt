package com.mizunotlt.chacknorrisjokes2.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mizunotlt.chacknorrisjokes2.data.JokesData
import com.mizunotlt.chacknorrisjokes2.repository.JokesRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class JokesModel @Inject constructor(private val repository: JokesRepository): ViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val jokesLiveData = MutableLiveData<ArrayList<JokesData>>().apply { value = arrayListOf() }

    fun getJokes(jokesCount: Int){
        scope.launch {
            val jokes = repository.getJokesList(jokesCount)
            jokesLiveData.postValue(jokes)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}