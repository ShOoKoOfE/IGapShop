object Hilt {
    const val hiltVersion = "2.41"
    const val android = "com.google.dagger:hilt-android:$hiltVersion"
    const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
}

object HiltTest {
    private const val hiltTestVersion = "2.41"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:$hiltTestVersion"
    const val hiltCompilerTesting = "com.google.dagger:hilt-android-compiler:$hiltTestVersion"
}