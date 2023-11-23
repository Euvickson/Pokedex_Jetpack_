package br.com.euvickson.pokedex_jetpack_.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.euvickson.pokedex_jetpack_.data.DataOrException
import br.com.euvickson.pokedex_jetpack_.model.PokemonAPIRequest
import br.com.euvickson.pokedex_jetpack_.repository.PokemonRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    val data: MutableState<DataOrException<PokemonAPIRequest, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllPokemons()

            if(data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }

        }
    }

    fun getTotalPokemonCount(): Int {
        return data.value.data?.results?.size ?: return 0
    }
}