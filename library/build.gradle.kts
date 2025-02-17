import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21"
}

group = "com.havan.paladinos.business-logic.kmp"
version = "1.0.5"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    val xcframeworkName = "library"
    val xcf = XCFramework(xcframeworkName)
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            binaryOption("bundleId", "com.havan.paladinos.business-logic.kmp.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.logging)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktorSerialization)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.cio)
                implementation(libs.koin.android)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.client.android)
                implementation(libs.ktor.utils.jvm)
                implementation(libs.ktor.client.logging.jvm)
                implementation(libs.ktor.client.plugins)
            }
        }
        val iosMain by creating {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "org.jetbrains.kotlinx.multiplatform.library.template"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(group.toString(), "library", version.toString())

    pom {
        name = "Hvn Library KMP"
        description =
            "Biblioteca Kotlin Multiplatform para compartilhar lógica de negócios (use cases) entre aplicativos Android e iOS nativos."
        inceptionYear = "2024"
        url = " https://dev.azure.com/HavanLabs/PALADINOS/_git/havan-paladinos-kmp "
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                name = "Marcelo Luiz Pinheiro"
                email = "marcelo.pinheiro@havan.com"
            }

            developer {
                name = "Matheus de Araújo Leite"
                email = "matheus.a@havan.com.br"
            }

            developer {
                name = "Ana Cristina Pereira"
                email = "ana.cristinap@havan.com.br"
            }
        }
        scm {
            url = " https://dev.azure.com/HavanLabs/PALADINOS/_git/havan-paladinos-kmp "
        }
    }
}
