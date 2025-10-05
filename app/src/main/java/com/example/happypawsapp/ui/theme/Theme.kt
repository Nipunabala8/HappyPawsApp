package com.example.happypawsapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light and Dark color palettes
private val LightColors = lightColorScheme(
    primary = Color(0xFF2196F3),       // Blue
    secondary = Color(0xFF4CAF50),     // Green
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.White
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFF4CAF50),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black
)

@Composable
fun HappyPawsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
