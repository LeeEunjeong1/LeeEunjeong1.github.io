package io.github.leeeunjeong1.portfolio.core.model

data class Project(
    val id: String,
    val name: String,
    val description: String,
    val tags: List<String>,
    val period: String,
    val role: String,
    val overview: String,
    val highlights: List<String>,
    val imageUrls: List<String> = emptyList(),
    val githubUrl: String? = null,
    val serviceUrl: String? = null,
)
