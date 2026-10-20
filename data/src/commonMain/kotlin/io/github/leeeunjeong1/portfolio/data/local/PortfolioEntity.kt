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
    val id: String,
    val isCompanyProject: Boolean = false,
    val featured: Boolean = true,
    val name: String,
    val description: String,
    val tags: List<String>,
    val period: String,
    val role: String,
    val team: String,
    val overview: String,
    val highlights: List<String>,
    val areas: List<ProjectAreaEntity> = emptyList(),
    val screenTitles: List<String>,
    val challenges: List<ProjectChallengeEntity>,
    val imageUrls: List<String> = emptyList(),
    val githubUrl: String? = null,
    val serviceUrl: String? = null,
)

internal data class ProjectAreaEntity(
    val title: String,
    val period: String,
    val description: String,
    val highlights: List<String>,
    val achievements: List<String>,
)

internal data class ProjectChallengeEntity(
    val title: String,
    val problem: String,
    val solution: String,
    val result: String,
)
