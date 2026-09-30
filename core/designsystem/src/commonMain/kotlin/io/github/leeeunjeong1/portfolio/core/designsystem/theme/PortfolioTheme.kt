package io.github.leeeunjeong1.portfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import io.github.leeeunjeong1.portfolio.core.designsystem.resources.Res
import io.github.leeeunjeong1.portfolio.core.designsystem.resources.noto_sans_kr
import org.jetbrains.compose.resources.Font

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
    val fontFamily = FontFamily(Font(Res.font.noto_sans_kr))
    MaterialTheme(
        colorScheme = colors,
        typography = portfolioTypography(fontFamily),
        content = content,
    )
}

private fun portfolioTypography(fontFamily: FontFamily): Typography {
    val defaults = Typography()
    return Typography(
        displayLarge = defaults.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = defaults.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = defaults.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = defaults.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = defaults.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = defaults.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = defaults.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = defaults.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = defaults.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = defaults.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = defaults.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = defaults.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = defaults.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = defaults.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = defaults.labelSmall.copy(fontFamily = fontFamily),
    )
}
