package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection

@Composable
fun AboutSection(about: String) = PortfolioSection("About me") {
    Text(about, fontSize = 19.sp, lineHeight = 31.sp, modifier = Modifier.widthIn(max = 820.dp))
}
