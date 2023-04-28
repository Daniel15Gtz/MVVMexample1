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
import com.bumptech.glide.Glide
import com.example.rickmorty.R
import com.example.rickmorty.utils.api.Resource
import com.example.rickmorty.utils.api.Status
import com.example.rickmorty.utils.dto.RickMortyModel
import com.example.rickmorty.viewmodel.RickMortyViewModel
import kotlinx.android.synthetic.main.fragment_detail_characters.*
import kotlinx.android.synthetic.main.fragment_rickmorty_list.*


class RickMortyDetailsFragment : Fragment() {
    private lateinit var viewmodel: RickMortyViewModel

    private val detailsObserver = Observer<Resource<RickMortyModel>> {
        when (it.status) {
            Status.LOADING -> {
            }
            Status.SUCCESS -> {
                val character = it.data // Obtener el personaje desde el resultado de la solicitud
                // Mostrar el nombre del personaje en el TextView correspondiente
                tv_character_name.text = character!!.name
                // Obtener la URL de la imagen del personaje
                val imageUrl = character.image

                // Descargar y mostrar la imagen del personaje utilizando Glide
                Glide.with(requireContext())
                    .load(imageUrl)
                    .into(img_character)
            }
            Status.ERROR -> {
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
        return inflater.inflate(R.layout.fragment_detail_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObservers()
        addActions()
        viewmodel.setSelectCharacter(1)
    }

    fun addActions() {

    }

    private fun createObservers() {
        viewmodel.rickmortyDetail.observe(viewLifecycleOwner, detailsObserver)
    }


}