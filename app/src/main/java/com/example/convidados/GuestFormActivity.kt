package com.example.convidados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityGuestFormBinding
    private lateinit var  viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Estou atrelando a viewModel ao ciclo de vida. Quando a Activity morre a viewModel tb morre.
        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.btnSave.setOnClickListener(this)
        binding.radioPresente.isChecked = true

        val chave = intent.getStringExtra("chave")
        Log.d("debug", "logDaChave: ${chave}")

    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){

        }
    }
}