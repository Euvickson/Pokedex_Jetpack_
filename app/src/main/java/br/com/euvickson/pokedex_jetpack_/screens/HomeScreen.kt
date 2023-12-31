package br.com.euvickson.pokedex_jetpack_.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import br.com.euvickson.pokedex_jetpack_.Navigation.PokemonScreens
import br.com.euvickson.pokedex_jetpack_.component.SearchBar
import br.com.euvickson.pokedex_jetpack_.model.PokemonResult
import br.com.euvickson.pokedex_jetpack_.screens.viewmodel.PokemonViewModel
import coil.compose.SubcomposeAsyncImage

@Composable
fun HomeScreen(viewModel: PokemonViewModel = hiltViewModel(), navController: NavHostController) {
    ListOfPokemons(viewModel) {
        navController.navigate(route = PokemonScreens.DetailScreen.name + "/$it")
    }
}


@Composable
fun ListOfPokemons(viewModel: PokemonViewModel, onItemClicked: (id: Int) -> Unit) {

    val listOfPokemons = viewModel.pokemonList.value.data?.results
    val textState = remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    var isSearching by remember { mutableStateOf(false) }
    var pokemonListFiltered: MutableList<PokemonResult>? = mutableListOf()

    if (viewModel.pokemonList.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loading", "ListOfPokemons: Loading...")
    } else {

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, state = listState) {

            item {
                SearchBar(
                    valueState = textState,
                    labelId = "Search...",
                    enabled = true,
                    isSingleLine = true,
                ) {
                    if (it.isNotEmpty()) {
                        isSearching = true
                        pokemonListFiltered = viewModel.filterPokemon(it)
                    } else {
                        isSearching = false
                    }
                }
            }

            if (isSearching) {
                pokemonListFiltered?.forEachIndexed { index, pokemon ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onItemClicked(index + 1) },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SubcomposeAsyncImage(
                                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${index + 1}.png",
                                contentDescription = "Pokemon Image",
                                loading = {
                                    CircularProgressIndicator()
                                }
                            )
                            Text(
                                text = "# ${(index + 1).toString().padStart(3, '0')}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = pokemon.name,
                                modifier = Modifier.padding(bottom = 12.dp, top = 2.dp),
                                fontSize = 24.sp
                            )
                        }
                    }
                }
            } else {
                listOfPokemons?.forEachIndexed { index, pokemon ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onItemClicked(index + 1) },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SubcomposeAsyncImage(
                                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${index + 1}.png",
                                contentDescription = "Pokemon Image",
                                loading = {
                                    CircularProgressIndicator()
                                }
                            )
                            Text(
                                text = "# ${(index + 1).toString().padStart(3, '0')}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = pokemon.name,
                                modifier = Modifier.padding(bottom = 12.dp, top = 2.dp),
                                fontSize = 24.sp
                            )
                        }
                    }
                }
            }


        }
    }
}