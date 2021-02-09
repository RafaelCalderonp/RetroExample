package com.example.retroexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retroexample.remote.MarteRealState
import com.example.retroexample.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MarsRepository {

    private val retrofitClient = RetrofitClient.getRetrofit()
    private val dataFromInternet = MutableLiveData<List<MarteRealState>>()


    fun fetchDataMars(): LiveData<List<MarteRealState>>{
        Log.d("REPO,", "VIEJA CONFIABLE")
        retrofitClient.fetchMarsData().enqueue(object : Callback<List<MarteRealState>> {

            override fun onFailure(call: Call<List<MarteRealState>>, t: Throwable) {
                Log.e("REPO", "${t.message}")
            }

            override fun onResponse(
                call: Call<List<MarteRealState>>,
                response: Response<List<MarteRealState>>
            ) {
                when(response.code()){
                    in 200..299 -> dataFromInternet.value = response.body()
                    in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                    else -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                }
            }


        })
        return dataFromInternet
    }
}