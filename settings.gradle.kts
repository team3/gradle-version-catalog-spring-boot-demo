rootProject.name = "gradle-version-catalog-demo"

dependencyResolutionManagement {
    versionCatalogs {
        create("libsSpring") {
            library("spring-boot-starter-web", "org.springframework.boot", "spring-boot-starter-web").version("")
            library("spring-boot-starter-actuator", "org.springframework.boot", "spring-boot-starter-actuator").version("")
            library("spring-boot-devtools", "org.springframework.boot", "spring-boot-devtools").version("")
            library("spring-boot-starter-test", "org.springframework.boot", "spring-boot-starter-test").version("")

            bundle("spring", listOf("spring-boot-starter-web", "spring-boot-starter-actuator"))
        }

        create("libsCommon") {
            version("lombok", "1.18.20")

            library("lombok", "org.projectlombok", "lombok").versionRef("lombok")
        }
        create("libsKotlin") {
            library("jackson-module-kotlin", "com.fasterxml.jackson.module", "jackson-module-kotlin").version("")
            library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").version("")

        }
        create("libsSpringBoot3013") {
            version("spring", "3.0.13")
            version("springDependencyManagement", "1.1.3")

            plugin("spring-boot", "org.springframework.boot").versionRef("spring")
            plugin("spring-dependency-management", "io.spring.dependency-management").versionRef("springDependencyManagement")
        }
        create("libsSpringBoot320") {
            version("spring", "3.2.0")
            version("springDependencyManagement", "1.1.4")

            plugin("spring-boot", "org.springframework.boot").versionRef("spring")
            plugin("spring-dependency-management", "io.spring.dependency-management").versionRef("springDependencyManagement")
        }
    }
}

include("api", "web")
