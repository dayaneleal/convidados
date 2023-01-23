package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

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

        loadData()


    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){
            val name = binding.edtName.text.toString()
            val presence = binding.radioPresente.isChecked

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }

    private fun loadData(){
        val bundle = intent.extras

        if (bundle != null){
            val guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }

    }
}