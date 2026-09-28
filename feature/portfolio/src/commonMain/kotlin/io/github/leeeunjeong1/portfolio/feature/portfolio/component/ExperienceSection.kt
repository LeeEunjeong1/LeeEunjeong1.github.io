package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioCard
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection
import io.github.leeeunjeong1.portfolio.core.model.Experience

@Composable
fun ExperienceSection(experiences: List<Experience>) = PortfolioSection("Experience") {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        experiences.forEach { item ->
            PortfolioCard {
                Text(item.period, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Text(item.company, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(item.role, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .64f))
                Text(item.description, lineHeight = 25.sp)
            }
        }
    }
}
