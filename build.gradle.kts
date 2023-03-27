buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}