package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PortfolioFooter() {
    Text(
        "Built with Kotlin & Compose Multiplatform · © 2026 Eunjeong Lee",
        color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f),
        modifier = Modifier.padding(bottom = 24.dp),
    )
}
