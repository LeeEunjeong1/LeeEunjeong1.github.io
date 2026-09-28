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
        implementation(project(":core:model"))
        implementation(project(":domain"))
    }
}

android {
    namespace = "io.github.leeeunjeong1.portfolio.data"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
