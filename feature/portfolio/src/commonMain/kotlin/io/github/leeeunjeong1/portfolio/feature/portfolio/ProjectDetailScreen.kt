package io.github.leeeunjeong1.portfolio.feature.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioCard
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection
import io.github.leeeunjeong1.portfolio.core.model.Project
import io.github.leeeunjeong1.portfolio.core.model.ProjectChallenge

@Composable
fun ProjectDetailScreen(
    project: Project,
    projects: List<Project>,
    onProjectClick: (String) -> Unit,
    onBack: () -> Unit,
) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val compact = maxWidth < 840.dp
        Row(Modifier.fillMaxSize()) {
            if (!compact) {
                ProjectNavigation(projects, project.id, onProjectClick, onBack)
            }
            ProjectContent(project, compact, onBack, Modifier.weight(1f))
        }
    }
}

@Composable
private fun ProjectNavigation(
    projects: List<Project>,
    selectedProjectId: String,
    onProjectClick: (String) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(260.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TextButton(onClick = onBack, contentPadding = PaddingValues(0.dp)) {
            Text("← Portfolio", style = MaterialTheme.typography.bodyMedium)
        }
        Text("Projects", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        HorizontalDivider(Modifier.padding(vertical = 8.dp))
        projects.forEach { item ->
            val selected = item.id == selectedProjectId
            Surface(
                color = if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp),
            ) {
                TextButton(
                    onClick = { onProjectClick(item.id) },
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(14.dp),
                ) {
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(item.name, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                        Text(item.period, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectContent(
    project: Project,
    compact: Boolean,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 1080.dp)
                .fillMaxWidth()
                .padding(if (compact) 20.dp else 48.dp),
            verticalArrangement = Arrangement.spacedBy(if (compact) 40.dp else 64.dp),
        ) {
            if (compact) {
                TextButton(onClick = onBack, contentPadding = PaddingValues(0.dp)) {
                    Text("← 프로젝트 목록으로", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(project.name, fontSize = if (compact) 40.sp else 56.sp, fontWeight = FontWeight.Black)
                Text(project.description, fontSize = 20.sp, lineHeight = 30.sp)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    project.tags.forEach { tag ->
                        Surface(color = MaterialTheme.colorScheme.primaryContainer, shape = MaterialTheme.shapes.large) {
                            Text(tag, Modifier.padding(horizontal = 14.dp, vertical = 8.dp), fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            PortfolioCard {
                Text("프로젝트 정보", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text("기간  ${project.period}")
                Text("역할  ${project.role}")
                Text("구성  ${project.team}")
            }

            PortfolioSection("Screens") {
                if (compact) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        project.screenTitles.forEachIndexed { index, title -> ProjectScreenSlot(index, title) }
                    }
                } else {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        project.screenTitles.forEachIndexed { index, title ->
                            Box(Modifier.weight(1f)) { ProjectScreenSlot(index, title) }
                        }
                    }
                }
                Text(
                    "실제 앱 스크린샷을 준비하면 각 슬롯의 이미지 리소스만 교체할 수 있습니다.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                )
            }

            PortfolioSection("요약") {
                Text(project.overview, fontSize = 18.sp, lineHeight = 30.sp)
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    project.highlights.forEach { highlight -> Text("•  $highlight", lineHeight = 26.sp) }
                }
            }

            PortfolioSection("기술적 고민과 개선") {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    project.challenges.forEach { challenge -> ChallengeCard(challenge) }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                project.githubUrl?.let { url ->
                    OutlinedButton(onClick = { uriHandler.openUri(url) }) { Text("GitHub") }
                }
                project.serviceUrl?.let { url ->
                    Button(onClick = { uriHandler.openUri(url) }) { Text("서비스 보기") }
                }
            }
        }
    }
}

@Composable
private fun ProjectScreenSlot(index: Int, title: String) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.58f)
                .background(
                    color = if (index % 2 == 0) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(24.dp),
                )
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text("SCREEN\n${index + 1}", fontSize = 18.sp, fontWeight = FontWeight.Black, lineHeight = 24.sp)
        }
        Text(title, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ChallengeCard(challenge: ProjectChallenge) = PortfolioCard {
    Text(challenge.title, fontSize = 21.sp, fontWeight = FontWeight.Bold)
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(challenge.problem, lineHeight = 26.sp)
        Text(challenge.solution, lineHeight = 26.sp)
        Text(
            text = challenge.result,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 26.sp,
        )
    }
}
