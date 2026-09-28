package io.github.leeeunjeong1.portfolio.data.repository

import io.github.leeeunjeong1.portfolio.core.model.Portfolio
import io.github.leeeunjeong1.portfolio.data.local.PortfolioLocalDataSource
import io.github.leeeunjeong1.portfolio.data.mapper.toModel
import io.github.leeeunjeong1.portfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl(
    private val localDataSource: PortfolioLocalDataSource,
) : PortfolioRepository {
    override fun getPortfolio(): Portfolio = localDataSource.getPortfolio().toModel()
}
