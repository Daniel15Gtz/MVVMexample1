package com.example.rickmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.repository.RickMortyRepository
import com.example.rickmorty.utils.api.Resource
import com.example.rickmorty.utils.dto.RickMortyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RickMortyViewModel  : ViewModel(){
    private val rickmortyRepository = RickMortyRepository()
    val rickmortyList = MutableLiveData<Resource<List<RickMortyModel>>>()
    val rickmortyListEpisodes = MutableLiveData<Resource<List<RickMortyModel>>>()
    val rickmortyListLocation = MutableLiveData<Resource<List<RickMortyModel>>>()

    fun getRickMorty(){
        rickmortyList.value =  Resource.loading(null)
        viewModelScope.launch {
            val result = rickmortyRepository.getRickMorty()
            withContext(Dispatchers.Main){
                rickmortyList.value = result
            }
        }
    }
    fun getRickMortyEpisodes(){
        rickmortyListEpisodes.value =  Resource.loading(null)
        viewModelScope.launch {
            val result = rickmortyRepository.getRickMortyEpisodes()
            withContext(Dispatchers.Main){
                rickmortyListEpisodes.value = result
            }
        }
    }

    fun getRickMortyLocation(){
        rickmortyListLocation.value =  Resource.loading(null)
        viewModelScope.launch {
            val result = rickmortyRepository.getRickMortyLocation()
            withContext(Dispatchers.Main){
                rickmortyListLocation.value = result
            }
        }
    }
}