package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection

@Composable
fun SkillsSection(skills: List<String>) = PortfolioSection("Tech stack") {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        skills.forEach { skill ->
            Surface(shape = RoundedCornerShape(100), color = MaterialTheme.colorScheme.primary.copy(alpha = .14f)) {
                Text(skill, Modifier.padding(horizontal = 16.dp, vertical = 9.dp), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
