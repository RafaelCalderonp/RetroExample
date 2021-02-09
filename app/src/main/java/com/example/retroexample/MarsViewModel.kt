package com.example.retroexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retroexample.remote.MarteRealState

class MarsViewModel : ViewModel() {

    private val repository: MarsRepository
    val livedataFromInternet: LiveData<List<MarteRealState>>
    init {
        repository = MarsRepository()
        livedataFromInternet = repository.fetchDataMars()
    }
}