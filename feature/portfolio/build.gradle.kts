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
        implementation(project(":core:model"))
        implementation(project(":core:designsystem"))
        implementation(project(":domain"))
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.ui)
    }
}

android {
    namespace = "io.github.leeeunjeong1.portfolio.feature.portfolio"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
