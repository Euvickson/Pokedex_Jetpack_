package br.com.euvickson.pokedex_jetpack_.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import br.com.euvickson.pokedex_jetpack_.model.Stat
import br.com.euvickson.pokedex_jetpack_.model.TypeInfo
import java.util.Locale

fun pokemonColors (type: TypeInfo): Color {
    return when(type.name.lowercase()) {
        "normal" -> AppColors.TypeNormal
        "fire" -> AppColors.TypeFire
        "water" -> AppColors.TypeWater
        "eletric" -> AppColors.TypeEletric
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

fun pokemonStatColor(stat: Stat): Color {
    return when (stat.name.lowercase()) {
        "hp" -> AppColors.HPColor
        "attack" -> AppColors.AtkColor
        "defence" -> AppColors.DefColor
        "special-attack" -> AppColors.SpAtkColor
        "special-defense" -> AppColors.SpDefColor
        "speed" -> AppColors.SpdColor
        else -> Color.White
    }
}

fun PokemonStatReducedName(stat: Stat): String {
    return when(stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defence" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "spd"
        else -> ""
    }
}