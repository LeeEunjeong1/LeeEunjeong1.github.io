package io.github.leeeunjeong1.portfolio.feature.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.leeeunjeong1.portfolio.feature.portfolio.component.*

@Composable
fun PortfolioScreen(
    state: PortfolioUiState,
    onToggleTheme: () -> Unit,
) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val compact = maxWidth < 720.dp
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 1120.dp)
                    .fillMaxWidth()
                    .padding(if (compact) 20.dp else 48.dp),
                verticalArrangement = Arrangement.spacedBy(if (compact) 56.dp else 88.dp),
            ) {
                PortfolioHeader(darkMode = state.darkMode, onToggleTheme = onToggleTheme)
                HeroSection(portfolio = state.portfolio, compact = compact)
                AboutSection(state.portfolio.about)
                SkillsSection(state.portfolio.skills)
                ExperienceSection(state.portfolio.experiences)
                ProjectsSection(projects = state.portfolio.projects, compact = compact)
                ContactSection(state.portfolio.links.email)
                PortfolioFooter()
            }
        }
    }
}
