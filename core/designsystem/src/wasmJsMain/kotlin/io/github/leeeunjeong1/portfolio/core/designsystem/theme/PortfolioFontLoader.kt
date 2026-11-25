package io.github.leeeunjeong1.portfolio.core.designsystem.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.leeeunjeong1.portfolio.core.designsystem.resources.Res
import io.github.leeeunjeong1.portfolio.core.designsystem.resources.noto_sans_kr
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WithPreloadedPortfolioFont(content: @Composable () -> Unit) {
    if (preloadFont(Res.font.noto_sans_kr).value != null) {
        content()
    } else {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
