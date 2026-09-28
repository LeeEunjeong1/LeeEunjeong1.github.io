package io.github.leeeunjeong1.portfolio

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import io.github.leeeunjeong1.portfolio.core.designsystem.theme.PortfolioTheme
import io.github.leeeunjeong1.portfolio.data.local.PortfolioLocalDataSource
import io.github.leeeunjeong1.portfolio.data.repository.PortfolioRepositoryImpl
import io.github.leeeunjeong1.portfolio.domain.usecase.GetPortfolio
import io.github.leeeunjeong1.portfolio.feature.portfolio.PortfolioPresenter
import io.github.leeeunjeong1.portfolio.feature.portfolio.PortfolioScreen

@Composable
fun App() {
    val presenter = remember {
        val dataSource = PortfolioLocalDataSource()
        val repository = PortfolioRepositoryImpl(dataSource)
        PortfolioPresenter(GetPortfolio(repository))
    }
    var state by remember { mutableStateOf(presenter.initialState()) }

    PortfolioTheme(darkMode = state.darkMode) {
        Surface(Modifier.fillMaxSize()) {
            PortfolioScreen(
                state = state,
                onToggleTheme = { state = state.copy(darkMode = !state.darkMode) },
            )
        }
    }
}
