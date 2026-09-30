package io.github.leeeunjeong1.portfolio.navigation

sealed interface AppRoute {
    data object Home : AppRoute
    data class ProjectDetail(val projectId: String) : AppRoute

    fun toHash(): String = when (this) {
        Home -> "#/"
        is ProjectDetail -> "#/projects/$projectId"
    }

    companion object {
        fun fromHash(hash: String): AppRoute {
            val path = hash.removePrefix("#").trim('/')
            val segments = path.split('/').filter(String::isNotBlank)
            return if (segments.size == 2 && segments.first() == "projects") {
                ProjectDetail(segments.last())
            } else {
                Home
            }
        }
    }
}
