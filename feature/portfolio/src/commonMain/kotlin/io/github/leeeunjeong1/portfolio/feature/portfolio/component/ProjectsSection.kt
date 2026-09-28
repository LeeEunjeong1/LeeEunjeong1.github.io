package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioCard
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection
import io.github.leeeunjeong1.portfolio.core.model.Project

@Composable
fun ProjectsSection(projects: List<Project>, compact: Boolean) = PortfolioSection("Projects") {
    val uriHandler = LocalUriHandler.current
    if (compact) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            projects.forEach { project -> ProjectCard(project) { project.url?.let(uriHandler::openUri) } }
        }
    } else {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            projects.forEach { project ->
                Box(Modifier.weight(1f)) { ProjectCard(project) { project.url?.let(uriHandler::openUri) } }
            }
        }
    }
}

@Composable
private fun ProjectCard(project: Project, onClick: () -> Unit) = PortfolioCard {
    Text(project.name, fontSize = 25.sp, fontWeight = FontWeight.Bold)
    Text(project.description, lineHeight = 25.sp)
    Text(project.tags.joinToString("  ·  "), color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
    if (project.url != null) {
        TextButton(onClick = onClick, contentPadding = PaddingValues(0.dp)) { Text("프로젝트 보기 →") }
    }
}
