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
import com.example.convidados.databinding.FragmentAllGuestsBinding
import com.example.convidados.view.adapter.GuestsAdapter
import com.example.convidados.view.listener.OnGuestListener
import com.example.convidados.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: GuestsViewModel
    private val adapter = GuestsAdapter {
        onEditClick(it)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        //Layout - gerenciador de layout pra saber orientação da RecyclerView etc.
        //O LayoutManager diz como os elementos da RecyclerView irão se comportar
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
                viewModel.getAll()
            }
        }

        adapter.attachListener(listener)

        observe()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guestsLiveData.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }

    private fun onEditClick(id: Int){
        Toast.makeText(context, "Fui clicado - ID: ${id}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, GuestFormActivity::class.java)

        val bundle = Bundle()
        bundle.putInt(DataBaseConstants.GUEST.ID, id)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}