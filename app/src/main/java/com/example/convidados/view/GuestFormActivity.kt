package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityGuestFormBinding
    private lateinit var  viewModel: GuestFormViewModel

    companion object {
        const val TAG = "LifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Estou atrelando a viewModel ao ciclo de vida. Quando a Activity morre a viewModel tb morre.
        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.btnSave.setOnClickListener(this)
        binding.radioPresente.isChecked = true

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){
            val name = binding.edtName.text.toString()
            val presence = binding.radioPresente.isChecked

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}