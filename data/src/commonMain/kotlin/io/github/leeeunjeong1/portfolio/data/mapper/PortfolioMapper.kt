package io.github.leeeunjeong1.portfolio.data.mapper

import io.github.leeeunjeong1.portfolio.core.model.Experience
import io.github.leeeunjeong1.portfolio.core.model.Portfolio
import io.github.leeeunjeong1.portfolio.core.model.PortfolioLinks
import io.github.leeeunjeong1.portfolio.core.model.Project
import io.github.leeeunjeong1.portfolio.core.model.ProjectArea
import io.github.leeeunjeong1.portfolio.core.model.ProjectChallenge
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
            isCompanyProject = it.isCompanyProject,
            featured = it.featured,
            name = it.name,
            description = it.description,
            tags = it.tags,
            period = it.period,
            role = it.role,
            team = it.team,
            overview = it.overview,
            highlights = it.highlights,
            areas = it.areas.map { area ->
                ProjectArea(area.title, area.period, area.description, area.highlights, area.achievements)
            },
            screenTitles = it.screenTitles,
            challenges = it.challenges.map { challenge ->
                ProjectChallenge(challenge.title, challenge.problem, challenge.solution, challenge.result)
            },
            imageUrls = it.imageUrls,
            githubUrl = it.githubUrl,
            serviceUrl = it.serviceUrl,
        )
    },
    links = PortfolioLinks(githubUrl, blogUrl, emailUrl),
)
