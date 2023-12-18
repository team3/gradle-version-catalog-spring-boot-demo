import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libsSpringBoot3013.plugins.spring.boot)
    alias(libsSpringBoot3013.plugins.spring.dependency.management)
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
}

group = "com.example.api"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libsSpring.bundles.spring)
    implementation(libsKotlin.kotlin.reflect)
    implementation(libsKotlin.jackson.module.kotlin)
    compileOnly(libsCommon.lombok)
    developmentOnly(libsSpring.spring.boot.devtools)
    annotationProcessor(libsCommon.lombok)
    testImplementation(libsSpring.spring.boot.starter.test)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
