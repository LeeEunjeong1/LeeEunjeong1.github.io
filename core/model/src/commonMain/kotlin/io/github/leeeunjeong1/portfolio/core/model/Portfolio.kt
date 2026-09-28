package io.github.leeeunjeong1.portfolio.core.model

data class Portfolio(
    val name: String,
    val headline: String,
    val introduction: String,
    val about: String,
    val skills: List<String>,
    val experiences: List<Experience>,
    val projects: List<Project>,
    val links: PortfolioLinks,
)

data class PortfolioLinks(
    val github: String,
    val blog: String,
    val email: String,
)
