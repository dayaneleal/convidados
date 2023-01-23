package com.example.convidados.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

        private val repository = GuestRepository.getInstance(application)

        init {
                Log.d("LifeCycle", "init: ")
        }

        override fun onCleared() {
                Log.d("LifeCycle", "onCleared: ")
                super.onCleared()
        }

        fun insert(guest: GuestModel){
                repository.insert(guest)
        }
}