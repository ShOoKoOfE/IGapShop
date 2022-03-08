import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
}