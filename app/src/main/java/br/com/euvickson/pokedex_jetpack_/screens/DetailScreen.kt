package br.com.euvickson.pokedex_jetpack_.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.euvickson.pokedex_jetpack_.screens.viewmodel.PokemonViewModel

@Composable
fun DetailScreen(int: Int?, viewModel: PokemonViewModel = hiltViewModel()) {

    Text(text = int.toString())
    if (int != null) {
        viewModel.getPokemonDetail(int)
    }

    viewModel.pokemonDetail.value.data?.name?.let { Text(text = it) }
}