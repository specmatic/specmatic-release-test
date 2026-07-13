import io.specmatic.gradle.extensions.RepoType

plugins {
    id("io.specmatic.gradle")
}

specmatic {
    releasePublishTasks =
        listOf(
            "publishAllPublicationsToSpecmaticPrivateRepository",
            "publishAllPublicationsToSpecmaticSnapshotsRepository",
            "publishAllPublicationsToSpecmaticReleasesRepository",
        )


    promotion {
        targetMavenRepository(
            name = "specmaticReleases",
            url = "https://repo.specmatic.io/releases",
            type = RepoType.PUBLISH_OBFUSCATED_ONLY
        )
        canonicalMavenRepository = uri("https://repo.specmatic.io/snapshots")
        dockerImage("specmatic/release-test-snapshot", "specmatic/release-test")
    }

    withCommercialApplicationLibrary(project(":app")) {
        mainClass = "org.example.app.AppKt"
        githubRelease()
        dockerBuild {
            imageName = "release-test-snapshot"
        }
        publishTo("specmaticPrivate", "https://repo.specmatic.io/private", RepoType.PUBLISH_ALL)
        publishTo("specmaticSnapshots", "https://repo.specmatic.io/snapshots", RepoType.PUBLISH_OBFUSCATED_ONLY)
        publishTo("specmaticReleases", "https://repo.specmatic.io/releases", RepoType.PUBLISH_OBFUSCATED_ONLY)

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

