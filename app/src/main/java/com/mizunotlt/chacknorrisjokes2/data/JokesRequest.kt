package com.mizunotlt.chacknorrisjokes2.data

import com.google.gson.annotations.SerializedName

data class JokesRequest(
    @SerializedName("types") val types: String,
    @SerializedName("value") val value : ArrayList<JokesData>)

data class  JokesData(
    @SerializedName("id") val id: Int, val joke: String,
    @SerializedName("categories") val categories: ArrayList<String>)