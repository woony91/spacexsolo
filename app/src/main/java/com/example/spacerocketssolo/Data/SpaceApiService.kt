package com.example.spacerocketssolo.Data

import com.example.spacerocketssolo.Model.SpaceResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class SpaceApiService {

    private val BASE_URL = "https://api.spacexdata.com"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(SpaceApi::class.java)

    fun getRockets() : Single<List<SpaceResponse>> {
        return api.getRockets()
    }

}