package com.example.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.databinding.FragmentAbsentBinding
import com.example.convidados.view.adapter.GuestsAdapter
import com.example.convidados.view.listener.OnGuestListener
import com.example.convidados.viewmodel.GuestsViewModel

class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GuestsViewModel
    private val adapter = GuestsAdapter(::onEditClick)

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,b: Bundle?): View {
        viewModel =
            ViewModelProvider(this).get(GuestsViewModel::class.java)

        _binding = FragmentAbsentBinding.inflate(inflater, container, false)

        binding.recyclerGuests.layoutManager = LinearLayoutManager(context)

        //Adapter
        binding.recyclerGuests.adapter = adapter

        val listener = object : OnGuestListener {
            override fun onClick(id: Int) {
//                Toast.makeText(context, "Fui clicado", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(DataBaseConstants.GUEST.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAbsent()
            }
        }

        adapter.attachListener(listener)

        observe()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAbsent()
    }

    private fun observe() {
        viewModel.guestsLiveData.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }

    fun onEditClick(id: Int){
        Toast.makeText(context, "Fui clicado - ID: ${id}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, GuestFormActivity::class.java)

        val bundle = Bundle()
        bundle.putInt(DataBaseConstants.GUEST.ID, id)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}