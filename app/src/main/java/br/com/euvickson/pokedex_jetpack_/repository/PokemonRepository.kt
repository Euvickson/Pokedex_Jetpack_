package br.com.euvickson.pokedex_jetpack_.repository

import android.util.Log
import br.com.euvickson.pokedex_jetpack_.data.DataOrException
import br.com.euvickson.pokedex_jetpack_.model.PokemonAPIRequest
import br.com.euvickson.pokedex_jetpack_.network.PokemonAPI
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val api: PokemonAPI) {

    private val dataOrException = DataOrException<PokemonAPIRequest, Boolean, Exception>()

    suspend fun getAllPokemons(): DataOrException<PokemonAPIRequest, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllPokemon()

            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Pokemon Exception", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}