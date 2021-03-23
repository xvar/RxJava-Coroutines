package com.github.xvar.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    onPrimary = Color.Black,
    primaryVariant = Purple700,

    secondary = Teal200,
    onSecondary = Color.White,

    background = Color.Black,
    onBackground = Color.White,

    surface = Color.Black,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    onPrimary = Color.White,
    primaryVariant = Purple700,

    secondary = Teal200,
    onSecondary = Color.Black,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,
)

@Composable
fun RxJavaCoroutinesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    RxJavaCoroutinesTheme {
        content()
    }
}