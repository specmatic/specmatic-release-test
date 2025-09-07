import io.specmatic.gradle.extensions.RepoType
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("io.specmatic.gradle") version "0.13.1"
}

specmatic {
    kotlinVersion = "2.1.20"
    kotlinApiVersion = KotlinVersion.KOTLIN_2_1
    releasePublishTasks =
        listOf(
            "publishAllPublicationsToSpecmaticPrivateRepository",
            "publishAllPublicationsToSpecmaticSnapshotsRepository",
            "publishAllPublicationsToSpecmaticReleasesRepository",
        )

    publishTo("specmaticPrivate", "https://repo.specmatic.io/private", RepoType.PUBLISH_ALL)
    publishTo("specmaticSnapshots", "https://repo.specmatic.io/snapshots", RepoType.PUBLISH_OBFUSCATED_ONLY)
    publishTo("specmaticReleases", "https://repo.specmatic.io/releases", RepoType.PUBLISH_OBFUSCATED_ONLY)

    withCommercialApplicationLibrary(project(":app")) {
        mainClass = "org.example.app.AppKt"
        githubRelease()

        publish {
            pom {
                name = "Specmatic Release Test"
                description =
                    "TBD"
                url = "https://specmatic.io"
                licenses {
                    license {
                        name = "Specmatic EULA"
                        url = "https://specmatic.io/eula/"
                    }
                }
                developers {
                    developer {
                        id = "specmaticBuilders"
                        name = "Specmatic Builders"
                        email = "info@specmatic.io"
                    }
                }
            }
        }
    }

    withCommercialLibrary(project(":list")) {
        githubRelease()

        publish {
            pom {
                name = "Specmatic Release Test"
                description =
                    "TBD"
                url = "https://specmatic.io"
                licenses {
                    license {
                        name = "Specmatic EULA"
                        url = "https://specmatic.io/eula/"
                    }
                }
                developers {
                    developer {
                        id = "specmaticBuilders"
                        name = "Specmatic Builders"
                        email = "info@specmatic.io"
                    }
                }
            }
        }
    }
    withCommercialLibrary(project(":utilities")) {
        githubRelease()

        publish {
            pom {
                name = "Specmatic Release Test"
                description =
                    "TBD"
                url = "https://specmatic.io"
                licenses {
                    license {
                        name = "Specmatic EULA"
                        url = "https://specmatic.io/eula/"
                    }
                }
                developers {
                    developer {
                        id = "specmaticBuilders"
                        name = "Specmatic Builders"
                        email = "info@specmatic.io"
                    }
                }
            }
        }
    }
}
