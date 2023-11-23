package br.com.euvickson.pokedex_jetpack_.data

data class DataOrException <T, Boolean, E: Exception> (
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)