rootProject.name = "gradle-version-catalog-demo"

dependencyResolutionManagement {
    versionCatalogs {
        create("libsSpringBoot3013") {
            version("spring", "3.0.13")
            version("springDependencyManagement", "1.1.3")
            plugin(
                "spring-boot",
                "org.springframework.boot")
                .versionRef("spring")
            plugin(
                "spring-dependency-management",
                "io.spring.dependency-management"
            ).versionRef("springDependencyManagement")
        }
        create("libsSpringBoot320") {
            version("spring", "3.2.0")
            version("springDependencyManagement", "1.1.4")
            plugin(
                "spring-boot",
                "org.springframework.boot")
                .versionRef("spring")
            plugin(
                "spring-dependency-management",
                "io.spring.dependency-management"
            ).versionRef("springDependencyManagement")
        }
    }
}

include("api", "web")
