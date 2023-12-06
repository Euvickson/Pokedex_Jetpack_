package br.com.euvickson.pokedex_jetpack_.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.com.euvickson.pokedex_jetpack_.screens.viewmodel.PokemonViewModel
import coil.compose.SubcomposeAsyncImage

@Composable
fun DetailScreen(
    int: Int?,
    viewModel: PokemonViewModel = hiltViewModel(),
    navController: NavController,
    topPadding: Dp = 20.dp,
    pokemonImageSize: Dp = 200.dp
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 16.dp)) {

        PokemonDetailTopSection(
            navController = navController,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.2f).align(Alignment.TopCenter)
        )

        Box(contentAlignment = Alignment.TopCenter,modifier = Modifier
            .fillMaxSize()) {
            SubcomposeAsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$int.png",
                contentDescription = "Pokemon Image",
                loading = {
                    CircularProgressIndicator()
                },
                modifier = Modifier
                    .size(pokemonImageSize)
                    .offset(y = topPadding)
            )
        }
    }
}

@Composable
fun PokemonDetailTopSection(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier
            .background(
            brush = Brush.verticalGradient(
                listOf(
                    Color.Black,
                    Color.Transparent
                )
            )
        )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Arrow Back to the Pokemon List",
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Composable
fun PokemonDetailStateWrapper() {

}