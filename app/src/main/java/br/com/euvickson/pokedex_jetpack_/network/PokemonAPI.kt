package br.com.euvickson.pokedex_jetpack_.network

import br.com.euvickson.pokedex_jetpack_.model.Pokemon
import br.com.euvickson.pokedex_jetpack_.model.PokemonAPIRequest
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon

    @GET("pokemon?limit=100000&offset=0")
    suspend fun getAllPokemon(): PokemonAPIRequest

}