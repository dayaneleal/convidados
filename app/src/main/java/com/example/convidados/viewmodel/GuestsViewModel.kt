package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : GuestRepository =
        GuestRepository(application.applicationContext)

    private val _guestsLiveData = MutableLiveData<List<GuestModel>>()
    val guestsLiveData: LiveData<List<GuestModel>> = _guestsLiveData

    fun getAll() {
        _guestsLiveData.value = repository.getAll()
    }

    fun getAbsent() {
        _guestsLiveData.value = repository.getAbsent()
    }

    fun getPresent() {
        _guestsLiveData.value = repository.getPresent()
    }

    fun delete(id: Int){
        repository.delete(id)
    }
}