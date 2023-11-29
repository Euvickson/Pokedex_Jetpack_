package br.com.euvickson.pokedex_jetpack_.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.euvickson.pokedex_jetpack_.util.AppColors

@Composable
fun TypeBar(color: Color = AppColors.mDarkOrange, text: String = "Test") {
    Box(modifier = Modifier
        .padding(12.dp)
        .width(150.dp)
        .height(25.dp)
        .background(color),
        contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}