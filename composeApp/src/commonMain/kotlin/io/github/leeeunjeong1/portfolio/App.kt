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
import io.github.leeeunjeong1.portfolio.feature.portfolio.ProjectDetailScreen
import io.github.leeeunjeong1.portfolio.navigation.AppRoute
import io.github.leeeunjeong1.portfolio.navigation.currentLocationHash
import io.github.leeeunjeong1.portfolio.navigation.updateLocationHash

@Composable
fun App() {
    val presenter = remember {
        val dataSource = PortfolioLocalDataSource()
        val repository = PortfolioRepositoryImpl(dataSource)
        PortfolioPresenter(GetPortfolio(repository))
    }
    var state by remember { mutableStateOf(presenter.initialState()) }
    var route by remember { mutableStateOf(AppRoute.fromHash(currentLocationHash())) }

    fun navigate(destination: AppRoute) {
        route = destination
        updateLocationHash(destination.toHash())
    }

    PortfolioTheme(darkMode = state.darkMode) {
        Surface(Modifier.fillMaxSize()) {
            when (val currentRoute = route) {
                AppRoute.Home -> PortfolioScreen(
                    state = state,
                    onToggleTheme = { state = state.copy(darkMode = !state.darkMode) },
                    onProjectClick = { projectId -> navigate(AppRoute.ProjectDetail(projectId)) },
                )

                is AppRoute.ProjectDetail -> {
                    val project = state.portfolio.projects.firstOrNull { it.id == currentRoute.projectId }
                    if (project == null) {
                        navigate(AppRoute.Home)
                    } else {
                        ProjectDetailScreen(project = project, onBack = { navigate(AppRoute.Home) })
                    }
                }
            }
        }
    }
}
