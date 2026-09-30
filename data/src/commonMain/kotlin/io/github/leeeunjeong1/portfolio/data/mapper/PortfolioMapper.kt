package io.github.leeeunjeong1.portfolio.data.mapper

import io.github.leeeunjeong1.portfolio.core.model.Experience
import io.github.leeeunjeong1.portfolio.core.model.Portfolio
import io.github.leeeunjeong1.portfolio.core.model.PortfolioLinks
import io.github.leeeunjeong1.portfolio.core.model.Project
import io.github.leeeunjeong1.portfolio.data.local.PortfolioEntity

internal fun PortfolioEntity.toModel() = Portfolio(
    name = name,
    headline = headline,
    introduction = introduction,
    about = about,
    skills = skills,
    experiences = experiences.map { Experience(it.company, it.role, it.period, it.description) },
    projects = projects.map {
        Project(
            id = it.id,
            name = it.name,
            description = it.description,
            tags = it.tags,
            period = it.period,
            role = it.role,
            overview = it.overview,
            highlights = it.highlights,
            imageUrls = it.imageUrls,
            githubUrl = it.githubUrl,
            serviceUrl = it.serviceUrl,
        )
    },
    links = PortfolioLinks(githubUrl, blogUrl, emailUrl),
)
