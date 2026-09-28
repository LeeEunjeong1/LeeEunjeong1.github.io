package io.github.leeeunjeong1.portfolio.feature.portfolio

import io.github.leeeunjeong1.portfolio.domain.usecase.GetPortfolio

class PortfolioPresenter(
    private val getPortfolio: GetPortfolio,
) {
    fun initialState(): PortfolioUiState = PortfolioUiState(portfolio = getPortfolio())
}
