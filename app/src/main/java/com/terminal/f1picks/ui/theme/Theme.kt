package com.terminal.f1picks.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = RedNeon,
    secondary = White,
    background = DarkPetrolBlue,
    surface = DarkPetrolBlue,
    onPrimary = White,
    onSecondary = DarkPetrolBlue,
    onBackground = White,
    onSurface = White
)

@Composable
fun F1PicksTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
