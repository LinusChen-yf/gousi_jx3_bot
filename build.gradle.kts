plugins {
    val kotlinVersion = "1.7.20-Beta"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.12.1"
}

group = "top.timewl"
version = "1.0.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-okhttp:2.0.3") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.jetbrains.kotlinx")
    }
    implementation ("com.alibaba:fastjson:2.0.7")
}

