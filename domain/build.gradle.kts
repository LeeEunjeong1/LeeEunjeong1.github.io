import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()
    iosArm64()
    iosSimulatorArm64()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    sourceSets.commonMain.dependencies {
        api(project(":core:model"))
    }
}

android {
    namespace = "io.github.leeeunjeong1.portfolio.domain"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
