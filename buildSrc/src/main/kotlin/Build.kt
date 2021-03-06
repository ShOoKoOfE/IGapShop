object Build {
    private const val androidBuildToolsVersion = "7.1.1"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"
    const val realmAndroid = "io.realm:realm-gradle-plugin:${Realm.realmVersion}"
    const val realmTransformer = "io.realm:realm-transformer:${Realm.realmVersion}"
}