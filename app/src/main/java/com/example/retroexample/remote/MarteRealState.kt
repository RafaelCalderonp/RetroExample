package com.example.retroexample.remote

import com.google.gson.annotations.SerializedName

data class MarteRealState(
    @SerializedName("id")
    val id: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("img_src")
    val imgSrc: String

)
