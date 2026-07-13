plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-text:1.15.0")
    implementation(project(":utilities"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
}
