package io.github.leeeunjeong1.portfolio.domain.repository

import io.github.leeeunjeong1.portfolio.core.model.Portfolio

interface PortfolioRepository {
    fun getPortfolio(): Portfolio
}
