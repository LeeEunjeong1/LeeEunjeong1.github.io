package io.github.leeeunjeong1.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.github.leeeunjeong1.portfolio.core.designsystem.theme.WithPreloadedPortfolioFont

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport { WithPreloadedPortfolioFont { App() } }
}
