package com.mizunotlt.chacknorrisjokes2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mizunotlt.chacknorrisjokes2.models.JokesModel
import com.mizunotlt.chacknorrisjokes2.utils.Adapter
import kotlinx.android.synthetic.main.joke_fragment.*
import java.lang.NumberFormatException
import javax.inject.Inject


class JokeFragment : Fragment() {

    companion object {
        fun newInstance() = JokeFragment()
    }

    @Inject lateinit var jokesViewModel: JokesModel
    private lateinit var adapterJokes: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(jokeFragment = this@JokeFragment)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.joke_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        buttonReload.setOnClickListener {
            try{
                jokesViewModel.getJokes(countJokes.text.toString().toInt())
            }
            catch (e: NumberFormatException){
                Log.e("Error", "Error with input number")
            }
        }
        listJokes.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        adapterJokes = Adapter(arrayListOf())
        listJokes.adapter = adapterJokes
        jokesViewModel.jokesLiveData.observe(viewLifecycleOwner, Observer {
            adapterJokes.update(jokesViewModel.jokesLiveData.value!!)
        })

    }

}
