package com.cardona.leagueteamsapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData

class CommandsLiveData<T>: MutableLiveData<T>() {

    override fun postValue(value: T) {
        super.postValue(value)
        Thread.sleep(1500)
    }

}