package io.github.leeeunjeong1.portfolio.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
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
    MaterialTheme(colorScheme = colors) {
        ProvideTextStyle(
            value = MaterialTheme.typography.bodyLarge.copy(fontFamily = fontFamily),
            content = content,
        )
    }
}
