package io.github.leeeunjeong1.portfolio.feature.portfolio

import io.github.leeeunjeong1.portfolio.core.model.Portfolio

data class PortfolioUiState(
    val portfolio: Portfolio,
    val darkMode: Boolean = true,
)
