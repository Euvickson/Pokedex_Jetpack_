package br.com.euvickson.pokedex_jetpack_.model

data class PokemonAPIRequest(
    val count: Int,
    val next: Any,
    val previous: Any,
    var results: List<PokemonResult>
)