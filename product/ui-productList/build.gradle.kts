apply {
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}
dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.dataSource))
    "implementation"(project(Modules.interactors))
    "implementation"(SqlDelight.androidDriver)
    "implementation"(Coil.coil)
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
}