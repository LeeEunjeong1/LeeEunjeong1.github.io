package io.github.leeeunjeong1.portfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun PortfolioTheme(
    darkMode: Boolean,
    content: @Composable () -> Unit,
) {
    val colors = if (darkMode) {
        darkColorScheme(primary = Accent, background = DarkBackground, surface = DarkSurface)
    } else {
        lightColorScheme(primary = LightPrimary, background = LightBackground, surface = Color.White)
    }
    MaterialTheme(colorScheme = colors, content = content)
}
