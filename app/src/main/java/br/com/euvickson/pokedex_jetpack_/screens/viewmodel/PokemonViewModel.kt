package br.com.euvickson.pokedex_jetpack_.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.euvickson.pokedex_jetpack_.data.DataOrException
import br.com.euvickson.pokedex_jetpack_.model.Pokemon
import br.com.euvickson.pokedex_jetpack_.model.PokemonAPIRequest
import br.com.euvickson.pokedex_jetpack_.model.PokemonResult
import br.com.euvickson.pokedex_jetpack_.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    val pokemonList: MutableState<DataOrException<PokemonAPIRequest, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    val pokemonDetail: MutableState<DataOrException<Pokemon, Boolean, Exception>>
            = mutableStateOf(DataOrException(null, true, Exception("")))

    private var pokemonListFiltered: MutableList<PokemonResult> = mutableListOf()
    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            pokemonList.value.loading = true
            pokemonList.value = repository.getAllPokemons()

            if(pokemonList.value.data.toString().isNotEmpty()) {
                pokemonList.value.loading = false
            }

        }
    }

    fun getPokemonDetail(id: Int) {

        viewModelScope.launch {
            pokemonDetail.value.loading = true
            pokemonDetail.value = repository.getPokemonDetail(id)

            if (pokemonDetail.value.data.toString().isNotEmpty()) {
                pokemonDetail.value.loading = false
            }

        }

    }

    fun filterPokemon(string: String) {

    }
}