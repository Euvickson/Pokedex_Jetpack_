package br.com.euvickson.pokedex_jetpack_.model

data class Pokemon(
    val name: String,
    val id: Int,
    val stats: List<PokemonStatus>,
    val types: List<PokemonType>,
    val weight: Int,
    val height: Int
)