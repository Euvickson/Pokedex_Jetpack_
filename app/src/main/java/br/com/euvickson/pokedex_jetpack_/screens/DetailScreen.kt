package br.com.euvickson.pokedex_jetpack_.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(int: Int?) {

    Text(text = int.toString())

}