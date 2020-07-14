import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Versions {
    const val swaggerAnnotationsVersion = "1.5.14"
    const val findBugsVersion = "3.0.2"
    const val jacksonNullableVersion = "0.1.0"
}

object Configuration {
    const val hanakoApiPackage = "com.tiwindsoftware.hanako.api"
}

plugins {
    id("java")
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.openapi.generator") version "4.3.1"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

group = "com.tiwindsoftware"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.swagger:swagger-annotations:${Versions.swaggerAnnotationsVersion}")
    implementation("com.google.code.findbugs:jsr305:${Versions.findBugsVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.openapitools:jackson-databind-nullable:${Versions.jacksonNullableVersion}")
    implementation("javax.validation:validation-api")
    runtimeOnly("io.r2dbc:r2dbc-postgresql")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

sourceSets {
    main {
        java {
            srcDir("$buildDir/generated/src/main/java")
        }
    }
}

tasks.named<JavaCompile>("compileJava")
tasks.named("compileJava") {
    dependsOn(":openApiGenerate")
}

openApiGenerate {
    validateSpec.set(true)
    generatorName.set("spring")
    inputSpec.set("$rootDir/docs/v1/USERS.yaml")
    outputDir.set("$buildDir/generated")

    // Package names
    packageName.set(Configuration.hanakoApiPackage)
    apiPackage.set("${Configuration.hanakoApiPackage}.stubs")
    modelPackage.set("${Configuration.hanakoApiPackage}.models")
    invokerPackage.set(Configuration.hanakoApiPackage)

    // Spring configuration options
    configOptions.put("interfaceOnly", "true")
    configOptions.put("reactive", "true")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
