package com.example.retroexample.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsAPI {

    @GET("realestate")
    fun fetchMarsData() : Call<List<MarteRealState>>  //Vieja confiable

    @GET("realestate")
    suspend fun fetchMarsDataCoroutine() : Response<List<MarteRealState>> //Nueva Forma

    //En esta Interface deberia colocar PUT y todos los vervos
}