package com.example.rickmorty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickmorty.R
import kotlinx.android.synthetic.main.fragment_rickmorty_detail.*

class RickMortyDetailFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_rickmorty_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addActions()
    }

    private fun addActions() {

        btn_regresar.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}