package io.github.leeeunjeong1.portfolio.data.local

internal data class PortfolioEntity(
    val name: String,
    val headline: String,
    val introduction: String,
    val about: String,
    val skills: List<String>,
    val experiences: List<ExperienceEntity>,
    val projects: List<ProjectEntity>,
    val githubUrl: String,
    val blogUrl: String,
    val emailUrl: String,
)

internal data class ExperienceEntity(
    val company: String,
    val role: String,
    val period: String,
    val description: String,
)

internal data class ProjectEntity(
    val name: String,
    val description: String,
    val tags: List<String>,
    val url: String?,
)
