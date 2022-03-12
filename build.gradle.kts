
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroid)
        classpath(Build.realmAndroid)
        classpath(Build.realmTransformer)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
