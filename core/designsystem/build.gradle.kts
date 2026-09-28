import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget()
    iosArm64()
    iosSimulatorArm64()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    sourceSets.commonMain.dependencies {
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.ui)
        implementation(compose.components.resources)
    }
}

compose.resources {
    packageOfResClass = "io.github.leeeunjeong1.portfolio.core.designsystem.resources"
}

android {
    namespace = "io.github.leeeunjeong1.portfolio.core.designsystem"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
