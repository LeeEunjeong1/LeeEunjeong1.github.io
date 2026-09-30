package io.github.leeeunjeong1.portfolio.feature.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

@Composable
fun ProjectDetailScreen(
    project: Project,
    onBack: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val compact = maxWidth < 720.dp
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 960.dp)
                    .fillMaxWidth()
                    .padding(if (compact) 20.dp else 48.dp),
                verticalArrangement = Arrangement.spacedBy(if (compact) 40.dp else 64.dp),
            ) {
                TextButton(onClick = onBack, contentPadding = PaddingValues(0.dp)) {
                    Text(
                        text = "← 프로젝트 목록으로",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(project.name, fontSize = if (compact) 40.sp else 56.sp, fontWeight = FontWeight.Black)
                    Text(project.description, fontSize = 20.sp, lineHeight = 30.sp)
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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
                }

                PortfolioSection("Overview") {
                    Text(project.overview, fontSize = 18.sp, lineHeight = 30.sp)
                }

                PortfolioSection("What I did") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        project.highlights.forEach { highlight -> Text("•  $highlight", lineHeight = 26.sp) }
                    }
                }

                if (project.imageUrls.isNotEmpty()) {
                    PortfolioSection("Screens") {
                        Text("프로젝트 화면 이미지 영역 — 이미지 리소스를 연결하면 이곳에 표시됩니다.")
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
}
