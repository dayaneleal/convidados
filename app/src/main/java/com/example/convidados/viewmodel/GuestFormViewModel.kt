package com.example.convidados.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.model.SuccessFailure
import com.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository(application)

    private val guestModel = MutableLiveData<GuestModel>()
    var guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<SuccessFailure>()
    var saveGuest: LiveData<SuccessFailure> = _saveGuest

    init {
        Log.d("LifeCycle", "init: ")
    }

    override fun onCleared() {
        Log.d("LifeCycle", "onCleared: ")
        super.onCleared()
    }

    fun save(guest: GuestModel) {
        var successFailure = SuccessFailure(true, "")
        if (guest.id == 0) {
            successFailure.success = repository.insert(guest)
            successFailure.message = "Inserido com sucesso"
        } else {
            successFailure.success = repository.update(guest)
            successFailure.message = "Atualizado com sucesso"
        }

        _saveGuest.value = successFailure
    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}