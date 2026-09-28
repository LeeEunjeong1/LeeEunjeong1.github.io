package io.github.leeeunjeong1.portfolio.core.model

data class Project(
    val name: String,
    val description: String,
    val tags: List<String>,
    val url: String? = null,
)
