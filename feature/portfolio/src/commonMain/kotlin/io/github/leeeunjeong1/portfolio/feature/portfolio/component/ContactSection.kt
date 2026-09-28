package io.github.leeeunjeong1.portfolio.feature.portfolio.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.sp
import io.github.leeeunjeong1.portfolio.core.designsystem.component.PortfolioSection

@Composable
fun ContactSection(emailUrl: String) = PortfolioSection("Let’s connect") {
    val uriHandler = LocalUriHandler.current
    Text("함께 만들고 싶은 제품이나 나누고 싶은 이야기가 있다면 편하게 연락해 주세요.", fontSize = 19.sp)
    Button(onClick = { uriHandler.openUri(emailUrl) }) { Text("tbig1019@gmail.com") }
}
