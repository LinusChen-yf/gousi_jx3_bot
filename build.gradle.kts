plugins {
    val kotlinVersion = "1.7.20-Beta"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.12.1"
}

group = "top.timewl"
version = "1.0.0"

repositories {
//    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    implementation ("com.alibaba:fastjson:2.0.7")
}

