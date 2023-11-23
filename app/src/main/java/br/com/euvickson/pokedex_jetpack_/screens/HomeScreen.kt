package br.com.euvickson.pokedex_jetpack_.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.euvickson.pokedex_jetpack_.screens.viewmodel.PokemonViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun HomeScreen(viewModel: PokemonViewModel = hiltViewModel()) {
    ListOfPokemons(viewModel)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ListOfPokemons(viewModel: PokemonViewModel) {
    val listOfPokemons = viewModel.data.value.data?.results

    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loading", "ListOfPokemons: Loading...")
    } else {
        LazyColumn {
            listOfPokemons?.forEachIndexed { index, pokemon ->
                item {
                    GlideImage(
                        model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${index + 1}.png",
                        contentDescription = "Pokemon Image"
                    )
                    Text(text = pokemon.name)
                }
            }
//            listOfPokemons?.forEach { pokemon ->
//                item {
//                    GlideImage(
//                        model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
//                        contentDescription = "Pokemon Image"
//                    )
//                    Text(text = pokemon.name)
//                }
//            }
        }
    }
}