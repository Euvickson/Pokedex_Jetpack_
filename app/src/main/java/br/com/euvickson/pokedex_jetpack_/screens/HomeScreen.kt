package br.com.euvickson.pokedex_jetpack_.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.euvickson.pokedex_jetpack_.screens.viewmodel.PokemonViewModel
import coil.compose.AsyncImage

@Composable
fun HomeScreen(viewModel: PokemonViewModel = hiltViewModel()) {
    ListOfPokemons(viewModel)
}

@Composable
fun ListOfPokemons(viewModel: PokemonViewModel) {
    val listOfPokemons = viewModel.data.value.data?.results
    val pokemonDetail = viewModel.pokemonDetail

    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loading", "ListOfPokemons: Loading...")
    } else {
        LazyColumn {

            item {
                Text(text = pokemonDetail.value.data?.id.toString())
            }

            listOfPokemons?.forEachIndexed { index, pokemon ->
                item {
                    AsyncImage(
                        model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${index + 1}.png",
                        contentDescription = "Pokemon Image"
                    )
                    Text(text = pokemon.name)
                }
            }

        }
    }
}