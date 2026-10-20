package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioCard
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection
import io.github.leeeunjeong1.portfolio.core.model.Project

@Composable
fun ProjectsSection(
    projects: List<Project>,
    compact: Boolean,
    onProjectClick: (String) -> Unit,
) = PortfolioSection("Projects") {
    val companyProjects = projects.filter(Project::isCompanyProject)
    val personalProjects = projects.filterNot(Project::isCompanyProject)

    ProjectGroup(
        title = "회사 프로젝트",
        description = "실제 서비스의 개발과 운영에 참여한 프로젝트",
        projects = companyProjects,
        compact = compact,
        onProjectClick = onProjectClick,
    )

    Spacer(Modifier.height(36.dp))
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
    Spacer(Modifier.height(36.dp))

    ProjectGroup(
        title = "개인 프로젝트",
        description = "아이디어를 직접 구현하며 기술을 탐구한 프로젝트",
        projects = personalProjects.filter(Project::featured),
        compact = compact,
        onProjectClick = onProjectClick,
    )

    val smallerPersonalProjects = personalProjects.filterNot(Project::featured)
    if (smallerPersonalProjects.isNotEmpty()) {
        Spacer(Modifier.height(24.dp))
        Text("기타 개인 프로젝트", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            smallerPersonalProjects.forEach { project ->
                CompactProjectCard(project) { onProjectClick(project.id) }
            }
        }
    }
}

@Composable
private fun ProjectGroup(
    title: String,
    description: String,
    projects: List<Project>,
    compact: Boolean,
    onProjectClick: (String) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(title, fontSize = 23.sp, fontWeight = FontWeight.Bold)
        Text(description, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    Spacer(Modifier.height(18.dp))
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        if (compact) {
            projects.forEach { project ->
                ProjectCard(project) { onProjectClick(project.id) }
            }
        } else {
            projects.chunked(2).forEach { rowProjects ->
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    rowProjects.forEach { project ->
                        Box(Modifier.weight(1f)) {
                            ProjectCard(project) { onProjectClick(project.id) }
                        }
                    }
                    if (rowProjects.size == 1) Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun ProjectCard(project: Project, onClick: () -> Unit) = PortfolioCard {
    Text(project.period, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
    Text(project.name, fontSize = 25.sp, fontWeight = FontWeight.Bold)
    Text(project.description, lineHeight = 25.sp)
    Text(project.tags.joinToString("  ·  "), color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
    TextButton(onClick = onClick, contentPadding = PaddingValues(0.dp)) {
        Text("프로젝트 상세 보기 →", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun CompactProjectCard(project: Project, onClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(14.dp),
    ) {
        TextButton(onClick = onClick, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(project.name, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text(
                    project.tags.take(2).joinToString(" · "),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}
