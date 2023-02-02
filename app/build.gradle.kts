/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.2/userguide/building_java_projects.html
 */

plugins {
    application
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
}

repositories { mavenCentral() }

val beamVersion = "2.42.0"

dependencies {
    // Kotlin dependencies.
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // App dependencies.
    implementation("org.apache.beam:beam-sdks-java-core:${beamVersion}")
    implementation("org.apache.beam:beam-runners-direct-java:${beamVersion}")
    implementation("org.slf4j:slf4j-jdk14:1.7.36")

    // Test dependencies.
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

application { mainClass.set("beam.starter.AppKt") }

// Test with JUnit 4.
tasks.test { useJUnit() }

// Package a self-contained jar file.
tasks.jar {
    archiveBaseName.set("pipeline")
    destinationDirectory.set(file("build"))
    manifest { attributes("Main-Class" to "beam.starter.AppKt") }
    exclude("META-INF/*.SF")
    exclude("META-INF/*.DSA")
    exclude("META-INF/*.RSA")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({ configurations.runtimeClasspath.get().map(::zipTree) })
}
