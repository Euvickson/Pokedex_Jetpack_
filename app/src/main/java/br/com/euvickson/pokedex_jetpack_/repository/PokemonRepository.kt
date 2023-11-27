package br.com.euvickson.pokedex_jetpack_.repository

import android.util.Log
import br.com.euvickson.pokedex_jetpack_.data.DataOrException
import br.com.euvickson.pokedex_jetpack_.model.Pokemon
import br.com.euvickson.pokedex_jetpack_.model.PokemonAPIRequest
import br.com.euvickson.pokedex_jetpack_.network.PokemonAPI
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val api: PokemonAPI) {

    private val dataOrException = DataOrException<PokemonAPIRequest, Boolean, Exception>()
    private val pokemonDetail = DataOrException<Pokemon, Boolean, Exception>()

    suspend fun getAllPokemons(): DataOrException<PokemonAPIRequest, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllPokemon()

            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Pokemon Exception", "getAllPokemon: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

    suspend fun getPokemonDetail(id: Int): DataOrException<Pokemon, Boolean, Exception> {
        try {
            pokemonDetail.loading = true
            pokemonDetail.data = api.getPokemon(id)

            if (pokemonDetail.data.toString().isNotEmpty()) pokemonDetail.loading = false
        } catch (exception: Exception) {
            pokemonDetail.e = exception
            Log.d("Pokemon Exception", "getPokemonDetail: ${pokemonDetail.e!!.localizedMessage}")
        }
        return pokemonDetail
    }
}