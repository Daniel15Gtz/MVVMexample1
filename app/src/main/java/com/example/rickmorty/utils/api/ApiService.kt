package com.example.rickmorty.utils.api

import com.example.rickmorty.utils.dto.RickMortyResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Interface de conexion entre el aplicativo y el microservicio
 */
interface ApiService {


    @GET
    suspend fun getRickMortyList(
        // aqui colocaremos los parametros para las peticiones que se realizan, en este caso en particular se manda un path para agregarlo a la URL base(https://pokeapi.co/api/v2/{path})
        @Url path: String
    ) : Response<RickMortyResponseBody> // obtenemos el cuerpo del resultado de la petición a traves de un dto(data transfer object), que nos permitira procesar de manera mas sencilla la respuesta
}