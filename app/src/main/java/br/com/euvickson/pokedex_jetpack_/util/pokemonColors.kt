package br.com.euvickson.pokedex_jetpack_.util

import androidx.compose.ui.graphics.Color
import br.com.euvickson.pokedex_jetpack_.model.Stat
import br.com.euvickson.pokedex_jetpack_.model.TypeInfo

fun pokemonTypeToColors (type: TypeInfo): Color {
    return when(type.name.lowercase()) {
        "normal" -> AppColors.TypeNormal
        "fire" -> AppColors.TypeFire
        "water" -> AppColors.TypeWater
        "electric" -> AppColors.TypeEletric
        "grass" -> AppColors.TypeGrass
        "ice" -> AppColors.TypeIce
        "fighting" -> AppColors.TypeFighting
        "poison" -> AppColors.TypePoison
        "ground" -> AppColors.TypeGround
        "flying" -> AppColors.TypeFlying
        "psychic" -> AppColors.TypePsychic
        "bug" -> AppColors.TypeBug
        "rock" -> AppColors.TypeRock
        "ghost" -> AppColors.TypeGhost
        "dragon" -> AppColors.TypeDragon
        "dark" -> AppColors.TypeDark
        "steel" -> AppColors.TypeSteel
        "fairy" -> AppColors.TypeFairy
        else -> Color.Black
    }
}

fun pokemonStatToColor(stat: Stat): Color {
    return when (stat.name.lowercase()) {
        "hp" -> AppColors.HPColor
        "attack" -> AppColors.AtkColor
        "defense" -> AppColors.DefColor
        "special-attack" -> AppColors.SpAtkColor
        "special-defense" -> AppColors.SpDefColor
        "speed" -> AppColors.SpdColor
        else -> Color.White
    }
}

fun pokemonStatReducedName(stat: Stat): String {
    return when(stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "spd"
        else -> ""
    }
}