package com.example.spacerocketssolo.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacerocketssolo.Data.SpaceApiService
import com.example.spacerocketssolo.Model.SpaceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel(){

    private val spaceService = SpaceApiService()
    private val disposable = CompositeDisposable()

    val rockets = MutableLiveData<List<SpaceResponse>>()
    val rocketsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        //return data from remote endpoint
        loading.value = true
        disposable.add(
            spaceService.getRockets()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<SpaceResponse>>(){
                    override fun onSuccess(rocketList: List<SpaceResponse>) {
                        rockets.value = rocketList
                        rocketsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        rocketsLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}