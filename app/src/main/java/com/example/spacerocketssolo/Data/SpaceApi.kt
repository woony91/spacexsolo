package com.example.spacerocketssolo.Data

import com.example.spacerocketssolo.Model.SpaceResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SpaceApi {
    @GET("v3/launches")
    fun getRockets(): Single<List<SpaceResponse>>


}