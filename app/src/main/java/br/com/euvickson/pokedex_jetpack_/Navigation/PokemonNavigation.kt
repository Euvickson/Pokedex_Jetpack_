package br.com.euvickson.pokedex_jetpack_.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.euvickson.pokedex_jetpack_.screens.DetailScreen
import br.com.euvickson.pokedex_jetpack_.screens.HomeScreen

@Composable
fun PokemonNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PokemonScreens.HomeScreen.name) {
        composable(PokemonScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(PokemonScreens.DetailScreen.name+"/{id}", arguments = listOf(navArgument(name = "id") {type = NavType.IntType})) {
            DetailScreen(it.arguments?.getInt("id"))
        }
    }
}