package com.example.spacerocketssolo.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacerocketssolo.Model.SpaceResponse

class DetailViewModel : ViewModel(){

    val rocketLiveData = MutableLiveData<SpaceResponse>()

    fun fetch() {
        val rocket = SpaceResponse("Mars", null, "2020", null, null, null, true)
        rocketLiveData.value = rocket
    }
}