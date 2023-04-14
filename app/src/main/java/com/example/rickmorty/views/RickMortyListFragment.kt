package com.example.rickmorty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rickmorty.R
import com.example.rickmorty.utils.api.Resource
import com.example.rickmorty.utils.api.Status
import com.example.rickmorty.utils.dto.RickMortyModel
import com.example.rickmorty.viewmodel.RickMortyViewModel

class RickMortyListFragment  : Fragment() {



    private lateinit var viewmodel : RickMortyViewModel

    private val rickmortyListObserver =  Observer<Resource<List<RickMortyModel>>>{
        when (it.status){
            Status.LOADING->{
            }
            Status.SUCCESS->{
            }
            Status.ERROR->{
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(requireActivity()).get(RickMortyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rickmorty_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addActions()
        createObservers()
        viewmodel.getRickMorty()
    }

    fun addActions(){
        requireView().findViewById<Button>(R.id.btn_siguiente).setOnClickListener {
            findNavController().navigate(R.id.action_rickmortyListFragment_to_rickmortyDetailFragment)
        }

    }

    private fun createObservers() {
        viewmodel.rickmortyList.observe(viewLifecycleOwner,rickmortyListObserver)
    }
}