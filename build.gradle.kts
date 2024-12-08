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
                // Add this for basic file operations
                implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val macosArm64Main by getting {
            dependencies {
                // Platform-specific file I/O
                implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")
            }
        }
    }
}
