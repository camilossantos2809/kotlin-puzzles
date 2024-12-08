plugins {
    kotlin("multiplatform") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    macosArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("com.squareup.okio:okio:3.5.0")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val macosArm64Main by getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
    }
}
