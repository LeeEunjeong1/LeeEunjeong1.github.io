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
}

android {
    namespace = "io.github.leeeunjeong1.portfolio.core.model"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
