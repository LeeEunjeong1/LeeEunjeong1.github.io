pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EunjeongPortfolio"
include(":composeApp")
include(":core:model")
include(":core:designsystem")
include(":domain")
include(":data")
include(":feature:portfolio")
