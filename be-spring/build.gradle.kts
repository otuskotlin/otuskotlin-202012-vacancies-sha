import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = rootProject.group
version = rootProject.group

dependencies {
    val serializationVersion: String by project
    val apacheCommonsLang3: String by project

    implementation(project(":common-multi"))
    implementation(project(":transport-multi"))
    implementation(project(":common-be"))
    implementation(project(":mapper"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(kotlin("stdlib"))
    implementation("org.apache.commons:commons-lang3:$apacheCommonsLang3")


    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
    implementation("org.springframework:spring-webmvc")

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }

    bootBuildImage {
        imageName = "be-spring:${rootProject.version}"
    }
}