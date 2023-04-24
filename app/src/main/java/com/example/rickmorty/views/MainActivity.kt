package com.example.rickmorty.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rickmorty.R


import com.example.rickmorty.viewmodel.RickMortyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RickMortyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(RickMortyViewModel::class.java)
    }
}