package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.model.Portfolio

@Composable
fun HeroSection(portfolio: Portfolio, compact: Boolean) {
    val uriHandler = LocalUriHandler.current
    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
        Text(
            "ANDROID DEVELOPER · KMP EXPLORER",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
        )
        Text(
            portfolio.headline,
            fontSize = if (compact) 42.sp else 68.sp,
            lineHeight = if (compact) 50.sp else 76.sp,
            fontWeight = FontWeight.Black,
        )
        Text(
            portfolio.introduction,
            fontSize = 18.sp,
            lineHeight = 29.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = .72f),
            modifier = Modifier.widthIn(max = 700.dp),
        )
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { uriHandler.openUri(portfolio.links.github) }) { Text("GitHub") }
            OutlinedButton(onClick = { uriHandler.openUri(portfolio.links.blog) }) { Text("Tistory") }
        }
    }
}
