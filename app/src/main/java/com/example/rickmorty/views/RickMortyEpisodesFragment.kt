package com.example.rickmorty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.R
import com.example.rickmorty.utils.api.Resource
import com.example.rickmorty.utils.api.Status
import com.example.rickmorty.utils.dto.RickMortyModel
import com.example.rickmorty.viewmodel.RickMortyViewModel
import com.example.rickmorty.views.adapter.RickMortyEpisodesListAdapter
import kotlinx.android.synthetic.main.fragment_rickmorty_list.*

class RickMortyEpisodesFragment  : Fragment() {



    private lateinit var viewmodel : RickMortyViewModel

    private val episodesObserver =  Observer<Resource<List<RickMortyModel>>>{
        when (it.status){
            Status.LOADING->{
            }
            Status.SUCCESS->{
                val adapter = RickMortyEpisodesListAdapter(it.data!!)
                rv_rickmorty_list.adapter = adapter
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
        return inflater.inflate(R.layout.fragment_episodes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObservers()
        addActions()
        viewmodel.getRickMortyEpisodes()
        rv_rickmorty_list.layoutManager = LinearLayoutManager(requireContext())
    }

    fun addActions(){
        tv_title_fragment_rickmorty.setText("Episodes")
        btn_fragment_rickmorty_siguiente.setText("Regresar location")
        btn_fragment_rickmorty_siguiente.setOnClickListener {
            findNavController().navigate(R.id.action_rickmortyDetailFragment_to_rickmortyListFragment)
        }
    }

    private fun createObservers() {
        viewmodel.rickmortyListEpisodes.observe(viewLifecycleOwner,episodesObserver)
    }


}