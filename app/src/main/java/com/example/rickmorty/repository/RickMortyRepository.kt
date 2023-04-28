package com.example.rickmorty.repository

import com.example.rickmorty.App
import com.example.rickmorty.BuildConfig
import com.example.rickmorty.R
import com.example.rickmorty.utils.api.*
import com.example.rickmorty.utils.dto.RickMortyModel
import java.lang.Exception

class RickMortyRepository {

    private var service: ApiService = RequestManager(BuildConfig.BASE_URL).create(ApiService::class.java)
    val application = App.instance


    suspend fun getRickMorty(): Resource<List<RickMortyModel>> {
        return try {
            val response = service.getRickMortyList(application.getString(R.string.service_rickmorty))
            Resource(Status.SUCCESS, response.body()!!.results, null)
        } catch (e: Exception) {
            Resource(Status.ERROR, null, ErrorModel(ErrorModel.Type.TOLERABLE, "No se pudo consultar el servicio, intente nuevamente"))
        }
    }
    suspend fun getRickMortyEpisodes(): Resource<List<RickMortyModel>> {
        return try {
            val response = service.getRickMortyList(application.getString(R.string.service_rickmorty_episodes))
            Resource(Status.SUCCESS, response.body()!!.results, null)
        } catch (e: Exception) {
            Resource(Status.ERROR, null, ErrorModel(ErrorModel.Type.TOLERABLE, "No se pudo consultar el servicio, intente nuevamente"))
        }
    }
    suspend fun getRickMortyLocation(): Resource<List<RickMortyModel>> {
        return try {
            val response = service.getRickMortyList(application.getString(R.string.service_rickmorty_location))
            Resource(Status.SUCCESS, response.body()!!.results, null)
        } catch (e: Exception) {
            Resource(Status.ERROR, null, ErrorModel(ErrorModel.Type.TOLERABLE, "No se pudo consultar el servicio, intente nuevamente"))
        }
    }
    suspend fun getCharacter(position: Int): Resource<RickMortyModel> {
        return try {
            val response = service.getDetailCharacter(application.getString(R.string.service_rickmorty)+position)
            Resource(Status.SUCCESS, response.body(), null)
        } catch (e: Exception) {
            Resource(Status.ERROR, null, ErrorModel(ErrorModel.Type.TOLERABLE, "No se pudo consultar el servicio, intente nuevamente"))
        }
    }
}