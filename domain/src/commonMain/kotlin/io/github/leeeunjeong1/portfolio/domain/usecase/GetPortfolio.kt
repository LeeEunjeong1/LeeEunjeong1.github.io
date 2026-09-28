package io.github.leeeunjeong1.portfolio.domain.usecase

import io.github.leeeunjeong1.portfolio.core.model.Portfolio
import io.github.leeeunjeong1.portfolio.domain.repository.PortfolioRepository

class GetPortfolio(
    private val repository: PortfolioRepository,
) {
    operator fun invoke(): Portfolio = repository.getPortfolio()
}
